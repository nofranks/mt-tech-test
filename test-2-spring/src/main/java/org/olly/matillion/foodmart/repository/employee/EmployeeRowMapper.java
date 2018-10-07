package org.olly.matillion.foodmart.repository.employee;

import org.olly.matillion.foodmart.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class EmployeeRowMapper implements RowMapper<Employee> {


    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee.EmployeeBuilder builder = Employee.EmployeeBuilder.getInstance()
                .id(resultSet.getInt("employee_id"))
                .fullname(resultSet.getString("full_name"))
                .firstname(resultSet.getString("first_name"))
                .lastname(resultSet.getString("last_name"))
                .positionId(resultSet.getInt("position_id"))
                .positionTitle(resultSet.getString("position_title"))
                .storeId(resultSet.getInt("store_id"))
                .departmentId(resultSet.getInt("department_id"))
                .salary(resultSet.getDouble("salary"))
                .supervisorId(resultSet.getInt("supervisor_id"))
                .educationLevel(resultSet.getString("education_level"))
                .maritalStatus(resultSet.getString("marital_status"))
                .gender(resultSet.getString("gender"))
                .managementRole(resultSet.getString("management_role"));
        Date birthDate = resultSet.getDate("birth_date");
        if(birthDate!=null)builder = builder.birthDate(birthDate.toLocalDate());
        Timestamp hireDate = resultSet.getTimestamp("hire_date");
        if(hireDate!=null)builder = builder.hireDate(hireDate.toLocalDateTime());
        Timestamp endDate = resultSet.getTimestamp("end_date");
        if(endDate!=null)builder = builder.endDate(endDate.toLocalDateTime());
        return builder.build();
    }
}
