package com.keysoft.soapwebserivce.generated;

import com.keysoft.soapwebserivce.ApplicationSOAPService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ApplicationServiceSoap {

    private String wsdUrl;
    private String nameSpaceUri;
    private String localPort;

    public ApplicationServiceSoap() {
        try {
            String path = getClass().getClassLoader().getResource("app-config.properties").getPath();
            InputStream configFile = new FileInputStream(path);
            final Properties properties = new Properties();
            properties.load(configFile);
            initConfig(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initConfig(Properties properties) {
        wsdUrl = properties.getProperty("WSD_URL");
        nameSpaceUri = properties.getProperty("NAMESPACE_URI");
        localPort = properties.getProperty("LOCAL_PART");
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
