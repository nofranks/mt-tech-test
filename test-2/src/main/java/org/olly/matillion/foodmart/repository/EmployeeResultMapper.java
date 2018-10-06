package org.olly.matillion.foodmart.repository;

import org.olly.matillion.foodmart.model.Employee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EmployeeResultMapper {

    public List<Employee> mapEmployeeResultSet(ResultSet resultSet) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        while(resultSet.next()){
            employeeList.add(mapRow(resultSet));
        }
        return employeeList;
    }

    public Employee mapRow(ResultSet resultSet)throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("employee_id"));
        employee.setFullname(resultSet.getString("full_name"));
        employee.setFirstname(resultSet.getString("first_name"));
        employee.setLastname(resultSet.getString("last_name"));
        employee.setPositionId(resultSet.getInt("position_id"));
        employee.setPositionTitle(resultSet.getString("position_title"));
        employee.setStoreId(resultSet.getInt("store_id"));
        employee.setDepartmentId(resultSet.getInt("department_id"));
        Date birthDate = resultSet.getDate("birth_date");
        if(birthDate!=null)employee.setBirthDate(birthDate.toLocalDate());
        Timestamp hireDate = resultSet.getTimestamp("hire_date");
        if(hireDate!=null)employee.setHireDate(hireDate.toLocalDateTime());
        Timestamp endDate = resultSet.getTimestamp("end_date");
        if(endDate!=null)employee.setEndDate(endDate.toLocalDateTime());
        employee.setSalary(resultSet.getDouble("salary"));
        employee.setSupervisorId(resultSet.getInt("supervisor_id"));
        employee.setEducationLevel(resultSet.getString("education_level"));
        employee.setMaritalStatus(resultSet.getString("marital_status"));
        employee.setGender(resultSet.getString("gender"));
        employee.setManagementRole(resultSet.getString("management_role"));
        return employee;
    }
}
