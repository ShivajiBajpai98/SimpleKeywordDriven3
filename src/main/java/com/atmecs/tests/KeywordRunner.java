package com.atmecs.tests;

import com.atmecs.config.ConfigReader;
import com.atmecs.core.DriverFactory;
import com.atmecs.keywords.KeywordFunctions;
import com.atmecs.senarios.Login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeywordRunner {
    private ConfigReader configReader;
    private DriverFactory driverFactory;
    private KeywordFunctions keywordFunctions;

    @BeforeClass
    public void setup() {
        // Read the configuration properties
        configReader = new ConfigReader("src/main/resources/config/config.properties", "src/main/resources/config/login.properties");

        // Initialize the WebDriver
        driverFactory = new DriverFactory();
        driverFactory.setupDriver(configReader.getProperty("browser"));

        // Create an instance of KeywordFunctions
        keywordFunctions = new KeywordFunctions(driverFactory.getDriver());
    }

    @Test
    public void executeLoginTest() {
        // Execute the login test scenario
        Login.executeTestSteps(configReader, keywordFunctions);
    }

    @AfterClass
    public void teardown() {
        // Quit the WebDriver
        driverFactory.quitDriver();
    }
}
