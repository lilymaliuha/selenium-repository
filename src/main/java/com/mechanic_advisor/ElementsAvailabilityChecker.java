package com.mechanic_advisor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class ElementsAvailabilityChecker {
    private static final int DEFAULT_TIMEOUT_IN_SECONDS = 30;

    /**
     * Waits until expected condition is true.
     *
     * @param condition specifies expected condition
     */
    public static void waitUntil(WebDriver driver, ExpectedCondition condition) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS));

        try {
            wait.until(condition);
        } catch (Throwable e) {
            throw new RuntimeException("Timed out after " + DEFAULT_TIMEOUT_IN_SECONDS + " seconds waiting for condition to be true.");
        }
    }

    /**
     * Waits for Angular JS processing.
     *
     * @return {@code boolean}
     */
    public static boolean waitForAngularJSProcessing(WebDriver driver) {
        boolean jQCondition = false;

        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS)) {}
                    .until((ExpectedCondition<Boolean>) driver1 -> Boolean.valueOf(((JavascriptExecutor) driver1).executeScript(
                            "return window.angular!= undefined && angular.element(document.getElementsByTagName('body'))" +
                                    ".injector().get('$http').pendingRequests.length === 0").toString()));
            jQCondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return jQCondition;
        } catch (Exception ignored) {
        }
        return jQCondition;
    }
}
