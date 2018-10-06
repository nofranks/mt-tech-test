package org.olly.matillion.foodmart.repository;

import org.olly.matillion.foodmart.FoodmartApplication;
import org.olly.matillion.foodmart.data.DataConnection;
import org.olly.matillion.foodmart.data.DataConnectionException;
import org.olly.matillion.foodmart.data.MySqlDataConnection;
import org.olly.matillion.foodmart.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

public class SqlEmployeeRepository implements EmployeeRepository {

    private static Logger log = LoggerFactory.getLogger(SqlEmployeeRepository.class);

    DataConnection dataConnection;
    EmployeeResultMapper resultMapper;

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
                    "left join position p on e.position_id = p.position_id " +
                    "where d.department_description = ? and p.pay_type = ? and e.education_level = ?";

    public SqlEmployeeRepository(){
        this.dataConnection = new MySqlDataConnection();
        this.resultMapper = new EmployeeResultMapper();
    }

    @Override
    public List<Employee> findEmployeesForDepartmentPaytypeAndEducationLevel(String department, String payType, String educationLevel) throws EmployeeQueryException, DataConnectionException {

        if(department == null || payType == null || educationLevel == null)
            throw new EmployeeQueryException("Required parameters are missing: department, pay type and education must be specified");

        try (
            Connection connection = dataConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(findEmployeesForDepartmentPaytypeAndEducationLevelQuery)) {
            stmt.setString(1, department);
            stmt.setString(2, payType);
            stmt.setString(3, educationLevel);

            try(ResultSet resultSet = stmt.executeQuery()){
                return resultMapper.mapEmployeeResultSet(resultSet);
            }

        }catch(SQLException e){
            log.error("findEmployeesForDepartmentPaytypeAndEducationLevel exception", e);
            throw new EmployeeQueryException("Employee query exception");
        }

    }



}
