package com.mechanic_advisor.pages.dialogs;

import com.mechanic_advisor.ElementsAvailabilityChecker;
import com.mechanic_advisor.test_data_container.AppointmentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppointmentDetailsDialog {

    protected WebDriver driver;

    @FindBy(xpath = "//div[starts-with(@class, 'popper___')]//div[starts-with(@class, 'icon___')]")
    private WebElement threeDotsElement;

    @FindBy(xpath = "//span[contains(text(), 'Edit Appointment')]")
    private WebElement editAppointmentItem;

    public AppointmentDetailsDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebElement getAppointmentType(AppointmentType appointmentType) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + appointmentType + "')] | //span[contains(text(),'" + appointmentType + "')]"));
    }

    public void openEditAppointmentDialog() {
        threeDotsElement.click();
        editAppointmentItem.click();
    }

    public boolean isAppointmentOfTypeDisplayed(AppointmentType appointmentType) {
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.visibilityOf(threeDotsElement));
        return getAppointmentType(appointmentType).isDisplayed();
    }
}
