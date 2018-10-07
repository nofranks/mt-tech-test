package org.olly.matillion.foodmart.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.olly.matillion.foodmart.data.DataConnectionException;
import org.olly.matillion.foodmart.model.Employee;
import org.olly.matillion.foodmart.repository.employee.EmployeeQueryException;
import org.olly.matillion.foodmart.service.FoodmartService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


public class FoodmartCommandLineRunnerTest {

    FoodmartCommandLineRunner commandLineRunner;
    FoodmartService foodmartService = mock(FoodmartService.class);
    EmployeeLogger employeeLogger = mock(EmployeeLogger.class);
    FoodmartConsoleReader consoleReader = mock(FoodmartConsoleReader.class);

    @BeforeEach
    public void setup(){
        commandLineRunner = new FoodmartCommandLineRunner(this.foodmartService);
        commandLineRunner.employeeLogger = this.employeeLogger;
        commandLineRunner.console = this.consoleReader;
    }

    @Test
    public void givenValidDepartmentPayTypeEducationLevel_whenExecuted_employeeListPrinted() throws DataConnectionException, EmployeeQueryException {
        String validInput = "validInput";
        List<Employee> employeeList = buildTestEmployeeList();
        when(foodmartService.findEmployees(eq(validInput), eq(validInput), eq(validInput))).thenReturn(employeeList);
        commandLineRunner.run(validInput, validInput, validInput);
        verify(employeeLogger, times(1)).outputEmployees(eq(employeeList));
    }

    @Test
    public void givenNoArguments_whenExecuted_userIsPromptedForDepartmentPayTypeEducationLevel() throws DataConnectionException, EmployeeQueryException {
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
    public void givenValidArguments_whenExecuted_DataConnectionException() throws DataConnectionException, EmployeeQueryException {
        String testInput = "test";
        when(foodmartService.findEmployees(any(String.class), any(String.class), any(String.class))).thenThrow(DataConnectionException.class);
        assertThrows(DataConnectionException.class, () -> foodmartService.findEmployees("test", "test", "test"));
        verify(foodmartService, times(1)).findEmployees(eq(testInput), eq(testInput), eq(testInput));
        verify(employeeLogger, times(0)).outputEmployees(any(List.class));
    }

    private List<Employee> buildTestEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee());
        return employeeList;
    }
}
