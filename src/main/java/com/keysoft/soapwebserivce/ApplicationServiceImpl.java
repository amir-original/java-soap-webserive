package com.keysoft.soapwebserivce;

import javax.jws.WebService;

@WebService(endpointInterface = "com.keysoft.soapwebserivce.ApplicationService",
        serviceName = "ApplicationServiceSOAP")
public class ApplicationServiceImpl implements ApplicationService {

    @Override
    public String getAll() {
        return "Hello World!";
    }
}
