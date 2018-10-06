package org.olly.matillion.foodmart.service;

import org.olly.matillion.foodmart.data.DataConnectionException;
import org.olly.matillion.foodmart.model.Employee;
import org.olly.matillion.foodmart.repository.EmployeeQueryException;
import org.olly.matillion.foodmart.repository.EmployeeRepository;
import org.olly.matillion.foodmart.repository.SqlEmployeeRepository;

import java.util.List;

public class FoodmartServiceImpl implements FoodmartService {

    EmployeeRepository employeeRepository;

    public FoodmartServiceImpl(){
        this.employeeRepository = new SqlEmployeeRepository();
    }

    @Override
    public List<Employee> findEmployees(String department, String payType, String educationLevel) throws EmployeeQueryException, DataConnectionException {
        return employeeRepository.findEmployeesForDepartmentPaytypeAndEducationLevel(department, payType, educationLevel);
    }
}
