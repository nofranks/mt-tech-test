package org.olly.matillion.foodmart.service;

import org.olly.matillion.foodmart.data.DataConnectionException;
import org.olly.matillion.foodmart.repository.EmployeeQueryException;
import org.olly.matillion.foodmart.model.Employee;

import java.util.List;

public interface FoodmartService {
    List<Employee> findEmployees(String department, String payType, String educationLevel) throws EmployeeQueryException, DataConnectionException;
}
