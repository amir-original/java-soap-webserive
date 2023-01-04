package com.keysoft.soapwebserivce.generated;

import com.keysoft.soapwebserivce.ApplicationSOAPService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationServiceSoap {

    private String wsdUrl;
    private String nameSpaceUri;
    private String localPort;
    private PropertiesReader fileReader;

    public ApplicationServiceSoap() {
      initConfig(new PropertiesReader("app-config"));
    }

    private void initConfig(PropertiesReader reader) {
        wsdUrl = reader.getProperty("WSD_URL");
        nameSpaceUri = reader.getProperty("NAMESPACE_URI");
        localPort = reader.getProperty("LOCAL_PART");
    }

    public ApplicationSOAPService getApplicationServicePort() {

        ApplicationSOAPService appService;
        try {
            URL wsdURL = new URL(wsdUrl);
            QName qualifiedName = new QName(nameSpaceUri, localPort);
            Service service = Service.create(wsdURL, qualifiedName);
            appService = service.getPort(ApplicationSOAPService.class);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return appService;

    }
}
