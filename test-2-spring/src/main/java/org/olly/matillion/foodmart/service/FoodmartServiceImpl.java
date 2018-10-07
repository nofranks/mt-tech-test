package org.olly.matillion.foodmart.service;

import org.olly.matillion.foodmart.model.Employee;
import org.olly.matillion.foodmart.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodmartServiceImpl implements FoodmartService {

    EmployeeRepository employeeRepository;

    @Autowired
    public FoodmartServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findEmployees(String department, String payType, String educationLevel) {
        return employeeRepository.findEmployeesForDepartmentPaytypeAndEducationLevel(department, payType, educationLevel);
    }
}
