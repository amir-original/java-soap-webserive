package com.keysoft.soapwebserivce.generated;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private final String resourcePath;

    public PropertiesReader(String fileName) {
        this.resourcePath = fileName + ".properties";
    }

    public String getProperty(String key) {
        String value = "";
        try {
            String path = getClass().getClassLoader().getResource(resourcePath).getPath();
            InputStream configFile = new FileInputStream(path);
            final Properties properties = new Properties();
            properties.load(configFile);
            value = properties.getProperty(key);
            configFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
