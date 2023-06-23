package com.mechanic_advisor.pages;

import com.mechanic_advisor.ElementsAvailabilityChecker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarPage {
    protected WebDriver driver;

    @FindBy(xpath ="//span[text()='New Appointment']/parent::button")
    private WebElement newAppointmentButton;

    @FindBy(className = "rbc-current")
    private WebElement calendarCurrentDay;

    @FindBy(xpath = "//div[starts-with(@class, 'eventInfo___')]//span[starts-with(@class, 'title___')]")
    private List<WebElement> appointmentInCalendar;
    public CalendarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnNewAppointmentButton() {
        newAppointmentButton.click();
    }

    public boolean isAppointmentPresentInCalendar(String appointmentName) {
        for (WebElement element : appointmentInCalendar) {
            if (element.getText().equals(appointmentName)) {
                return true;
            }
        }
        return false;
    }
}
