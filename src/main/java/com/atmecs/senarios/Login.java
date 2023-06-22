package com.atmecs.senarios;

import com.atmecs.config.ConfigReader;
import com.atmecs.keywords.KeywordFunctions;
import com.atmecs.tests.KeywordDrivenFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login
{
    public static void executeTestSteps(ConfigReader configReader, KeywordFunctions keywordFunctions) {
        List<Map<String, String>> testSteps = new ArrayList<>();

        // Test Step 1
        Map<String, String> step1 = new HashMap<>();
        step1.put("method", "openURL");
        step1.put("urlKey", "baseURL");
        testSteps.add(step1);

        // Test Step 2
        Map<String, String> step2 = new HashMap<>();
        step2.put("method", "enterText");
        step2.put("locatorTypeKey", "usernameLocatorType");
        step2.put("locatorValueKey", "usernameLocator");
        step2.put("textKey", "username");
        testSteps.add(step2);

        // Test Step 3
        Map<String, String> step3 = new HashMap<>();
        step3.put("method", "enterText");
        step3.put("locatorTypeKey", "passwordLocatorType");
        step3.put("locatorValueKey", "passwordLocator");
        step3.put("textKey", "password");
        testSteps.add(step3);

        // Test Step 4
        Map<String, String> step4 = new HashMap<>();
        step4.put("method", "clickElement");
        step4.put("locatorTypeKey", "loginButtonLocatorType");
        step4.put("locatorValueKey", "loginButtonLocator");
        testSteps.add(step4);

        // Iterate over the test steps and execute them
        for (Map<String, String> step : testSteps) {
            KeywordDrivenFramework. executeTestStep(configReader, keywordFunctions, step);
        }
    }
}