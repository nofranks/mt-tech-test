package org.olly.matillion.foodmart.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.olly.matillion.foodmart.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest @ActiveProfiles("test")
public class FoodmartServiceIT {

    @Autowired
    private FoodmartService foodmartService;

    @Test
    public void givenDepartmentPaytypeEducation_whenEmployeesRequested_returnEmployeeId4(){
        final String educationLevel = "Batchelors Degree";
        final Integer expectedEmployeeId = 4;
        List<Employee> employees = foodmartService.findEmployees("HQ General Management", "Monthly", educationLevel);
        assertEquals(1, employees.size());
        Employee employee = employees.get(0);
        assertEquals(educationLevel, employee.getEducationLevel());
        assertEquals(expectedEmployeeId, employee.getId());
    }

    @Test
    public void givenNullParameters_wheEmployeesRequested_expectEmptyEmployeeList() {
        List<Employee> employees = foodmartService.findEmployees(null, null, null);
        assertTrue(employees.isEmpty());
    }

}
