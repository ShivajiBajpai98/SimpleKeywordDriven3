package com.atmecs.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeywordFunctions {
    private WebDriver driver;
    private WebDriverWait wait;

    public KeywordFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void enterText(String locatorType, String locatorValue, String text) {
        WebElement element = findElement(locatorType, locatorValue);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(String locatorType, String locatorValue) {
        WebElement element = findElement(locatorType, locatorValue);
        element.click();
    }

    private WebElement findElement(String locatorType, String locatorValue) {
        By by;
        if (locatorType.equalsIgnoreCase("id")) {
            by = By.id(locatorValue);
        } else if (locatorType.equalsIgnoreCase("name")) {
            by = By.name(locatorValue);
        } else if (locatorType.equalsIgnoreCase("className")) {
            by = By.className(locatorValue);
        } else if (locatorType.equalsIgnoreCase("tagName")) {
            by = By.tagName(locatorValue);
        } else if (locatorType.equalsIgnoreCase("linkText")) {
            by = By.linkText(locatorValue);
        } else if (locatorType.equalsIgnoreCase("partialLinkText")) {
            by = By.partialLinkText(locatorValue);
        } else if (locatorType.equalsIgnoreCase("cssSelector")) {
            by = By.cssSelector(locatorValue);
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            by = By.xpath(locatorValue);
        } else {
            throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }

        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
