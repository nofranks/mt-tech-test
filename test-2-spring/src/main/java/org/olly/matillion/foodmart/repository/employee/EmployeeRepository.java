package org.olly.matillion.foodmart.repository.employee;

import org.olly.matillion.foodmart.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findEmployeesForDepartmentPaytypeAndEducationLevel(String department, String payType, String educationLevel);
}
