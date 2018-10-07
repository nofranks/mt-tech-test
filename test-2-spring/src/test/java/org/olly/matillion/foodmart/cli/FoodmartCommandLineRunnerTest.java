package org.olly.matillion.foodmart.cli;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.olly.matillion.foodmart.model.Employee;
import org.olly.matillion.foodmart.service.FoodmartService;
import org.springframework.jdbc.datasource.init.ScriptParseException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FoodmartCommandLineRunnerTest {

    FoodmartCommandLineRunner commandLineRunner;

    @Mock
    FoodmartService foodmartService;
    @Mock
    EmployeeLogger employeeLogger;
    @Mock
    FoodmartConsoleReader consoleReader;

    @Before
    public void setup(){
        commandLineRunner = new FoodmartCommandLineRunner();
        commandLineRunner.foodmartService = this.foodmartService;
        commandLineRunner.employeeLogger = this.employeeLogger;
        commandLineRunner.console = this.consoleReader;
    }

    @Test
    public void givenValidDepartmentPayTypeEducationLevel_whenExecuted_employeeListPrinted(){
        List<Employee> employeeList = buildTestEmployeeList();
        when(foodmartService.findEmployees(eq("valid"), eq("valid"), eq("valid"))).thenReturn(employeeList);
        commandLineRunner.run("valid", "valid", "valid");
        verify(employeeLogger, times(1)).outputEmployees(eq(employeeList));
    }

    @Test
    public void givenNoArguments_whenExecuted_userIsPromptedForDepartmentPayTypeEducationLevel(){
        final String department = "department";
        final String payType = "payType";
        final String educationLevel = "educationLevel";

        List<Employee> employeeList = buildTestEmployeeList();
        when(consoleReader.readLine()).thenReturn(department, payType, educationLevel);
        when(foodmartService.findEmployees(eq(department), eq(payType), eq(educationLevel))).thenReturn(employeeList);

        commandLineRunner.run();
        verify(foodmartService, times(1)).findEmployees(eq(department), eq(payType), eq(educationLevel));
        verify(employeeLogger, times(1)).outputEmployees(eq(employeeList));
    }

    @Test
    public void givenRuntimeException_whenExecuted_noResultsLogged(){
        when(foodmartService.findEmployees(any(String.class), any(String.class), any(String.class))).thenThrow(ScriptParseException.class);

        commandLineRunner.run("","","");
        verify(foodmartService, times(1)).findEmployees(any(String.class), any(String.class), any(String.class));
        verify(employeeLogger, times(0)).outputEmployees(any(List.class));
    }

    private List<Employee> buildTestEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee());
        return employeeList;
    }
}
