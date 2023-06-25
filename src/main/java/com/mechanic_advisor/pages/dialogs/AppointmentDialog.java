package com.mechanic_advisor.pages.dialogs;

import com.mechanic_advisor.ElementsAvailabilityChecker;
import com.mechanic_advisor.test_data_container.AppointmentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppointmentDialog {
    protected WebDriver driver;

    @FindBy(name ="title")
    private WebElement appointmentTitleInput;

    @FindBy(xpath = "//div[@id='modal']//div[starts-with(@class, 'iconContainer___')]")
    private WebElement datePickerElement;

    @FindBy(className = "react-datepicker__day--today")
    private WebElement datePickerCurrentDay;

    @FindBy(xpath = "//span[text()='Create']/parent::button")
    private WebElement createButton;

    @FindBy(xpath = "//span[text()='Save']/parent::button")
    private WebElement saveButton;

    public AppointmentDialog(WebDriver driver) {
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

    public void enterAppointmentTitle(String appointmentTitle) {
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.visibilityOf(appointmentTitleInput));
        appointmentTitleInput.clear();
        appointmentTitleInput.sendKeys(appointmentTitle);
    }

    public void selectAppointmentType(AppointmentType appointmentType) {
        getAppointmentType(appointmentType).click();
    }

    public void createNewAppointmentForToday(String appointmentTitle, AppointmentType appointmentType) {
        enterAppointmentTitle(appointmentTitle);
        selectAppointmentType(appointmentType);
        selectCurrentDayInDatePicker();
        createButton.click();
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.invisibilityOf(createButton));
        ElementsAvailabilityChecker.waitForAngularJSProcessing(driver);
    }

    public void editAppointmentNameAndType(String updatedAppointmentName, AppointmentType appointmentType) {
        enterAppointmentTitle(updatedAppointmentName);
        selectAppointmentType(appointmentType);
        saveButton.click();
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.invisibilityOf(saveButton));
        ElementsAvailabilityChecker.waitForAngularJSProcessing(driver);
    }
}
