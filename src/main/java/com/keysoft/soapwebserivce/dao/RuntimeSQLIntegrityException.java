package com.keysoft.soapwebserivce.dao;

import java.sql.SQLIntegrityConstraintViolationException;

public class RuntimeSQLIntegrityException extends RuntimeException {
    public RuntimeSQLIntegrityException(SQLIntegrityConstraintViolationException e) {
        super(e);
    }
}
