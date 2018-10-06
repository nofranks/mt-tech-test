package org.olly.matillion.foodmart.data;

import java.sql.Connection;

public interface DataConnection {

    Connection getConnection() throws DataConnectionException;

}
