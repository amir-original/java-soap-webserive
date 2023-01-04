package com.keysoft.soapwebserivce.dao;

import com.keysoft.soapwebserivce.Application;

import java.util.List;

public interface ApplicationDAO {

    List<Application> findAll();

    Application findById(int id);

    Application findByIdAndName(int id,String name);

    void addApplication(Application application);
    void delete(int id);

    void updateApplication(Application application);
}
