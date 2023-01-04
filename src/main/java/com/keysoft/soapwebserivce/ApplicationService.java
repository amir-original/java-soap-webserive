package com.keysoft.soapwebserivce;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ApplicationService {

    @WebMethod
    String getAll();
}
