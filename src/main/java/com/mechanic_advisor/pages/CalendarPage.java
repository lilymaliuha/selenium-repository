package com.mechanic_advisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarPage {
    protected WebDriver driver;

    @FindBy(xpath ="//span[text()='New Appointment']/parent::button")
    private WebElement newAppointmentButton;

    @FindBy(xpath = "//div[starts-with(@class, 'eventInfo___')]//span[starts-with(@class, 'title___')]")
    private List<WebElement> appointmentInCalendar;

    @FindBy(xpath = "//div[contains(@class, 'rbc-today')]/ancestor::div[contains(@class, 'rbc-month-row')]//button[contains(@class, 'rbc-show-more')]")
    private List<WebElement> moreButtonInTheRowOfCurrentDay;

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnNewAppointmentButton() {
        newAppointmentButton.click();
    }

    public boolean isAppointmentForTodayPresentInCalendar(String appointmentName) {
        moreButtonInTheRowOfCurrentDay.get(0).click();
        for (WebElement element : appointmentInCalendar) {
            if (element.getText().equals(appointmentName)) {
                return true;
            }
        }
        return false;
    }
}
