package org.olly.matillion.foodmart.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDataConnection implements DataConnection {

    final String JDBC_URL_PROPERTY = "foodmart.db.url";
    final String JDBC_USERNAME = "foodmart.db.username";
    final String JDBC_PASSWORD = "foodmart.db.password";

    private String jdbc_url = "jdbc:mysql://mysql-technical-test.cq5i4y35n9gg.eu-west-1.rds.amazonaws.com/foodmart";
    private String jdbc_username = "technical_test";
    private String jdbc_password = "HopefullyProspectiveDevsDontBreakMe";

    public MySqlDataConnection(){
        super();
        if(System.getProperty(JDBC_URL_PROPERTY)!=null)jdbc_url = System.getProperty(JDBC_URL_PROPERTY);
        if(System.getProperty(JDBC_USERNAME)!=null)jdbc_username = System.getProperty(JDBC_USERNAME);
        if(System.getProperty(JDBC_PASSWORD)!=null)jdbc_password = System.getProperty(JDBC_PASSWORD);
    }

    public Connection getConnection() throws DataConnectionException {
        try{
            return DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
        }catch(SQLException e){
            throw new DataConnectionException("Data repository connection failure");
        }
    }

}
