package org.olly.matillion.foodmart.cli;

import org.olly.matillion.foodmart.model.Employee;

import java.util.List;

public class EmployeeLogger {

    public void outputEmployees(List<Employee> employees){
        employees.stream().forEach(System.out::println);
    }
}
