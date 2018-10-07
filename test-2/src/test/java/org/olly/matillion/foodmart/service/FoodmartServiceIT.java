package org.olly.matillion.foodmart.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.olly.matillion.foodmart.data.DataConnectionException;
import org.olly.matillion.foodmart.model.Employee;
import org.olly.matillion.foodmart.repository.employee.EmployeeQueryException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("when querying for employees")
public class FoodmartServiceIT {

    private FoodmartService foodmartService;

    @BeforeEach
    public void setup(){
        foodmartService = new FoodmartServiceImpl();
    }

    @Test @DisplayName("receive list of employees with valid parameters")
    public void givenValidDepartmentPaytypeEducation_whenEmployeesRequested_expectEmployeeList() throws EmployeeQueryException, DataConnectionException {
        List<Employee> employees = foodmartService.findEmployees("HQ General Management", "Monthly", "Bachelors Degree");
        assertTrue(!employees.isEmpty());
        Employee employee = employees.get(0);
        assertEquals(1, employee.getDepartmentId().intValue());
    }

    @Test @DisplayName("receive empty list with null parameters")
    public void givenNullParameters_wheEmployeesRequested_expectEmptyList() throws DataConnectionException, EmployeeQueryException {
        List<Employee> employees = foodmartService.findEmployees(null, null, null);
        assertTrue(employees.isEmpty());

    }

}
