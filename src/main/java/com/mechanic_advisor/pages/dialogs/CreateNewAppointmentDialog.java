package com.mechanic_advisor.pages.dialogs;

import com.mechanic_advisor.ElementsAvailabilityChecker;
import com.mechanic_advisor.test_data_container.AppointmentType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreateNewAppointmentDialog {
    protected WebDriver driver;
    @FindBy(xpath ="//span[text()='Customer Appointment']")
    private WebElement customerAppointmentCheckbox;

    @FindBy(name ="title")
    private WebElement appointmentTitleInput;

    @FindBy(xpath = "//div[@id='modal']//div[starts-with(@class, 'iconContainer___')]")
    private WebElement datePickerElement;

    @FindBy(className = "react-datepicker__day--today")
    private WebElement datePickerCurrentDay;

    @FindBy(xpath = "//span[text()='Create']/parent::button")
    private WebElement createButton;
    public CreateNewAppointmentDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebElement getAppointmentType(AppointmentType appointmentType) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + appointmentType.getValue() + "')]"));
    }

    public void selectCurrentDayInDatePicker() {
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.elementToBeClickable(datePickerElement));
        datePickerElement.click();
        datePickerCurrentDay.click();
        datePickerCurrentDay.click();
    }
    public void createNewAppointmentForToday(String appointmentTitle, AppointmentType appointmentType) {
        appointmentTitleInput.sendKeys(appointmentTitle);
        getAppointmentType(appointmentType);
        selectCurrentDayInDatePicker();
        createButton.click();
        ElementsAvailabilityChecker.waitForAngularJSProcessing(driver);
    }
}
