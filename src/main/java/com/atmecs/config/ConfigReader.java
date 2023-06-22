package com.atmecs.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader(String... filePaths) {
        properties = loadProperties(filePaths);
    }

    private Properties loadProperties(String... filePaths) {
        Properties properties = new Properties();
        for (String filePath : filePaths) {
            try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1); // Terminate the program in case of configuration loading failure
            }
        }
        return properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
