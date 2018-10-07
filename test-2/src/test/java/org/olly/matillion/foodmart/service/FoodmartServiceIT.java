package org.olly.matillion.foodmart.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.olly.matillion.foodmart.data.DataConnectionException;
import org.olly.matillion.foodmart.model.Employee;
import org.olly.matillion.foodmart.repository.employee.EmployeeQueryException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("when querying for employees")
public class FoodmartServiceIT {

    private FoodmartService foodmartService;

    @BeforeEach
    public void setup(){
        foodmartService = new FoodmartServiceImpl();
    }

    @Test @DisplayName("receive list of employees with valid parameters")
    public void givenValidDepartmentPaytypeEducation_whenEmployeesRequested_returnEmployeeList() throws EmployeeQueryException, DataConnectionException {
        List<Employee> employees = foodmartService.findEmployees("HQ General Management", "Monthly", "Bachelors Degree");
        assertTrue(!employees.isEmpty());
        Employee employee = employees.get(0);
        assertEquals(1, employee.getDepartmentId().intValue());
    }

    @Test @DisplayName("fail with null parameters")
    public void givenNullParameters_wheEmployeesRequested_expectEmployeeDataException(){
        EmployeeQueryException thrownException = assertThrows(EmployeeQueryException.class, () -> foodmartService.findEmployees(null, null, null));
        assertEquals("Required parameters are missing: department, pay type and education must be specified", thrownException.getMessage());

    }

}
