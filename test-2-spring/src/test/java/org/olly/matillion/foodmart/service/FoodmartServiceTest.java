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
public class FoodmartServiceTest {

    @Autowired
    private FoodmartService foodmartService;

    @Test
    public void givenDepartmentPaytypeEducation_whenEmployeesRequested_returnThreeEmployees(){
        final String educationLevel = "Graduate Degree";
        List<Employee> employees = foodmartService.findEmployees("HQ General Management", "Monthly", educationLevel);
        assertTrue(!employees.isEmpty());
        Employee employee = employees.get(0);
        assertEquals(educationLevel, employee.getEducationLevel());
    }

    @Test
    public void givenNullParameters_wheEmployeesRequested_expectEmptyEmployeeList() {
        List<Employee> employees = foodmartService.findEmployees(null, null, null);
        assertTrue(employees.isEmpty());
    }

}
