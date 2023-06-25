package com.mechanic_advisor.pages;

import com.mechanic_advisor.ElementsAvailabilityChecker;
import com.mechanic_advisor.test_data_container.CalendarView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarPage {
    protected WebDriver driver;

    @FindBy(xpath = "//span[text()='New Appointment']/parent::button")
    private WebElement newAppointmentButton;

    @FindBy(xpath = "//div[starts-with(@class, 'eventInfo___')]//span[starts-with(@class, 'title___')] | //div[starts-with(@class, 'title___')]")
    private List<WebElement> appointmentInCalendar;

    @FindBy(xpath = "//div[starts-with(@class, 'viewSelect')]")
    private WebElement calendarViewSelector;

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebElement getCalendarViewOption(CalendarView calendarView) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + calendarView.getValue() + "')]"));
    }

    private WebElement getAppointmentElementByName(String appointmentName) {
        return driver.findElement(By.xpath("//div[contains(text(), '" + appointmentName + "')] | " +
                "//span[contains(text(),'" + appointmentName + "')]"));
    }

    public void clickOnNewAppointmentButton() {
        newAppointmentButton.click();
    }

    public void selectCalendarPageView(CalendarView calendarViewOption) {
        ElementsAvailabilityChecker.waitUntil(driver, ExpectedConditions.elementToBeClickable(calendarViewSelector));
        calendarViewSelector.click();
        getCalendarViewOption(calendarViewOption).click();
    }

    public void openAppointmentDetailsDialog(String appointmentName) {
        getAppointmentElementByName(appointmentName).click();
    }

    public boolean isAppointmentForTodayPresentInCalendar(String appointmentName) {
        for (WebElement element : appointmentInCalendar) {
            if (element.getText().equals(appointmentName)) {
                return true;
            }
        }
        return false;
    }
}
