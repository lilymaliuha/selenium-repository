package com.mechanic_advisor.pages.dialogs;

import com.mechanic_advisor.ElementsAvailabilityChecker;
import com.mechanic_advisor.test_data_container.AppointmentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteAppointmentDialog {

    protected WebDriver driver;

    @FindBy(xpath = "//span[text()='Yes, Delete']/parent::button")
    private WebElement approveDeleteButton;

    public DeleteAppointmentDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void deleteAppointment() {
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.elementToBeClickable(approveDeleteButton));
        approveDeleteButton.click();
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.invisibilityOf(approveDeleteButton));
        ElementsAvailabilityChecker.waitForAngularJSProcessing(driver);
    }
}
