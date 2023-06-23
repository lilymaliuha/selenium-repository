package com.mechanic_advisor.pages.modules;

import com.mechanic_advisor.ElementsAvailabilityChecker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NavigationModule {
    protected WebDriver driver;

    @FindBy(xpath ="//a[starts-with(@class, 'nestedLink___')]")
    private WebElement nestedSidebarLink;

    @FindBy(xpath ="//a//div[text()='Calendar']")
    private WebElement calendarElement;

    @FindBy(xpath = "//div[starts-with(@class, 'linkWrapper__')]")
    private List<WebElement> navigationMenuItems;

    public NavigationModule(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void  clickOnMenuItem(int indexOfMenuItem) {
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.elementToBeClickable(nestedSidebarLink));
        navigationMenuItems.get(indexOfMenuItem).click();
    }

    public void openCalendar(int indexOfMenuItem) {
        clickOnMenuItem(indexOfMenuItem);
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.elementToBeClickable(calendarElement));
        calendarElement.click();
    }
}
