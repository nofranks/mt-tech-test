package org.olly.matillion.foodmart.repository.employee;

import org.olly.matillion.foodmart.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SqlEmployeeRepository implements EmployeeRepository {

    JdbcTemplate jdbcTemplate;

    final String findEmployeesForDepartmentPaytypeAndEducationLevelQuery =
        "Select e.employee_id," +
                "e.full_name," +
                "e.first_name," +
                "e.last_name," +
                "e.position_id," +
                "e.position_title," +
                "e.store_id," +
                "e.department_id," +
                "e.birth_date," +
                "e.hire_date," +
                "e.end_date," +
                "e.salary," +
                "e.supervisor_id," +
                "e.education_level," +
                "e.marital_status," +
                "e.gender," +
                "e.management_role from employee e " +
                "inner join department d on e.department_id = d.department_Id " +
                "inner join position p on e.position_id = p.position_id " +
                "where d.department_description = ? and p.pay_type = ? and e.education_level = ?";

    @Autowired
    public SqlEmployeeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findEmployeesForDepartmentPaytypeAndEducationLevel(String department, String payType, String educationLevel){
        return jdbcTemplate.query(findEmployeesForDepartmentPaytypeAndEducationLevelQuery,
                new String[]{department, payType, educationLevel}, new EmployeeRowMapper());
    }

}
