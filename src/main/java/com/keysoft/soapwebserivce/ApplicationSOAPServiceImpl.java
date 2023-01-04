package com.keysoft.soapwebserivce;

import com.keysoft.soapwebserivce.dao.ApplicationDAOImpl;
import com.keysoft.soapwebserivce.service.ApplicationService;
import com.keysoft.soapwebserivce.service.ApplicationServiceImpl;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.keysoft.soapwebserivce.ApplicationSOAPService",
        serviceName = "ApplicationServiceSOAP")
public class ApplicationSOAPServiceImpl implements ApplicationSOAPService {

    private final ApplicationService service;

    public ApplicationSOAPServiceImpl() {
        service = new ApplicationServiceImpl(new ApplicationDAOImpl());
    }

    @Override
    public List<Application> getAll() {
        return service.findAll();
    }

    @Override
    public Application getApplication(int id) {
        return service.findById(id);
    }
}
