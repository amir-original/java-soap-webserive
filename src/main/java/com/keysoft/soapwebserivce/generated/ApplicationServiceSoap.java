package com.keysoft.soapwebserivce.generated;

import com.keysoft.soapwebserivce.ApplicationSOAPService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationServiceSoap {

    private static final String WSD_URL = "http://localhost:8080/soap-webserivce-1.0-SNAPSHOT/ApplicationServiceSOAP?wsdl";
    private static final String NAMESPACE_URI = "http://soapwebserivce.keysoft.com/";
    private static final String LOCAL_PART = "ApplicationServiceSOAP";

    public ApplicationServiceSoap() {

    }

    public ApplicationSOAPService getApplicationServicePort() {

        ApplicationSOAPService appService;
        try {
            URL wsdURL = new URL(WSD_URL);
            QName qualifiedName = new QName(NAMESPACE_URI, LOCAL_PART);
            Service service = Service.create(wsdURL, qualifiedName);
            appService = service.getPort(ApplicationSOAPService.class);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return appService;

    }
}
