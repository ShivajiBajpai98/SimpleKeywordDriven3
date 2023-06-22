package runner;

import com.atmecs.config.ConfigReader;
import com.atmecs.core.DriverFactory;
import com.atmecs.keywords.KeywordFunctions;
import com.atmecs.senarios.Login;
import com.atmecs.senarios.Search;

public class KeywordRunner
{
    public static void main(String[] args) {
        // Load the configuration properties
        ConfigReader configReader = new ConfigReader("src/main/resources/config/config.properties",
                "src/main/resources/config/login.properties","src/main/resources/config/search.properties");

        // Set up WebDriver
        String browserName = configReader.getProperty("browserName");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.setupDriver(browserName);

        // Create an instance of KeywordFunctions
        KeywordFunctions keywordFunctions = new KeywordFunctions(driverFactory.getDriver());

        // Execute test steps
        Search.executeTestSteps(configReader, keywordFunctions);

        // Quit the WebDriver
        driverFactory.quitDriver();
    }

}
