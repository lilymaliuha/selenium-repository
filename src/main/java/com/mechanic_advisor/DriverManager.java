package com.mechanic_advisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver createWebDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(options);
            }
            case FIREFOX -> {
                driver = new FirefoxDriver();
            }
            case CHROME_REMOTE -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                try {
                    driver = new RemoteWebDriver(new URL("https://dev2frontend.ngrok.io/"), options);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> driver = new ChromeDriver();
        }
        return driver;
    }
}
