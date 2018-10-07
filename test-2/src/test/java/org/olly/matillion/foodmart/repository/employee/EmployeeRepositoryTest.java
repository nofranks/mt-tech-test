package org.olly.matillion.foodmart.repository.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.olly.matillion.foodmart.data.DataConnection;
import org.olly.matillion.foodmart.data.DataConnectionException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EmployeeRepositoryTest {

    DataConnection connection = mock(DataConnection.class);
    SqlEmployeeRepository employeeRepository;

    @BeforeEach
    public void setup(){
        employeeRepository = new SqlEmployeeRepository();
    }

    @Test
    public void givenBrokenConnection_whenQueryingEmployees_expectDataConnectionException() throws DataConnectionException {
        when(connection.getConnection()).thenThrow(DataConnectionException.class);
        employeeRepository.dataConnection = connection;
        assertThrows(DataConnectionException.class, () -> employeeRepository.findEmployeesForDepartmentPaytypeAndEducationLevel("test", "test", "test"));
    }
}
