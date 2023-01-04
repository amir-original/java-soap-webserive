package com.keysoft.soapwebserivce.generated;

import com.keysoft.soapwebserivce.ApplicationSOAPService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationServiceSoap {

    public ApplicationSOAPService getApplicationServicePort() {

        ApplicationSOAPService appService;
        try {
            URL wsdURL = new URL("http://localhost:8080/soap-webserivce-1.0-SNAPSHOT/ApplicationServiceSOAP?wsdl");
            QName qualifiedName = new QName("http://soapwebserivce.keysoft.com/", "ApplicationServiceSOAP");
            Service service = Service.create(wsdURL, qualifiedName);
            appService = service.getPort(ApplicationSOAPService.class);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return appService;

    }
}
