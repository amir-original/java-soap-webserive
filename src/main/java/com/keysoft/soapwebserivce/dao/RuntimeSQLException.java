package com.keysoft.soapwebserivce.dao;

import java.sql.SQLException;

public class RuntimeSQLException extends RuntimeException {
    public RuntimeSQLException(SQLException e) {
        super(e);
    }
}
