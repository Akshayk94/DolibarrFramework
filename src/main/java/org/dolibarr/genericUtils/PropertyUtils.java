package org.dolibarr.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    Properties prop=new Properties();
    FileInputStream inputStream;

    public PropertyUtils() throws IOException {
        inputStream=new FileInputStream("src/test/resources/configuration.properties");
        prop.load(inputStream);
    }

    public String getValue(String key) {
        String value=prop.getProperty(key);
        return value;
    }
}
