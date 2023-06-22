package com.atmecs.tests;

import com.atmecs.config.ConfigReader;
import com.atmecs.keywords.KeywordFunctions;

import java.util.Map;

public class KeywordDrivenFramework {
    public static void executeTestStep(ConfigReader configReader, KeywordFunctions keywordFunctions, Map<String, String> step) {
        String method = step.get("method");
        String locatorTypeKey = step.get("locatorTypeKey");
        String locatorValueKey = step.get("locatorValueKey");
        String textKey = step.get("textKey");
        String urlKey = step.get("urlKey");

        switch (method) {
            case "openURL":
                String url = configReader.getProperty(urlKey);
                keywordFunctions.openURL(url);
                break;
            case "enterText":
                String locatorType = configReader.getProperty(locatorTypeKey);
                String locatorValue = configReader.getProperty(locatorValueKey);
                String text = configReader.getProperty(textKey);
                keywordFunctions.enterText(locatorType, locatorValue, text);
                break;
            case "clickElement":
                locatorType = configReader.getProperty(locatorTypeKey);
                locatorValue = configReader.getProperty(locatorValueKey);
                keywordFunctions.clickElement(locatorType, locatorValue);
                break;
            default:
                System.out.println("Invalid test step: " + method);
        }
    }
}
