package com.mechanic_advisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(id ="username")
    private WebElement usernameInput;

    @FindBy(id ="password")
    private WebElement passwordInput;

    @FindBy(className ="button_primary___2nooz")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
    }
}
