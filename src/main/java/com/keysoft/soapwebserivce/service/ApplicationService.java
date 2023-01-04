package com.keysoft.soapwebserivce.service;

import com.keysoft.soapwebserivce.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> findAll();

    Application findById(int id);

    Application findByIdAndName(int id,String name);

    void addApplication(Application application);

    void updateApplication(Application application);

    void delete(int id);
}
