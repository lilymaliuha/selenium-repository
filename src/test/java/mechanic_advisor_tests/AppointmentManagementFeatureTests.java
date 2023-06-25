package mechanic_advisor_tests;

import com.mechanic_advisor.pages.CalendarPage;
import com.mechanic_advisor.pages.LoginPage;
import com.mechanic_advisor.pages.dialogs.AppointmentDetailsDialog;
import com.mechanic_advisor.pages.dialogs.AppointmentDialog;
import com.mechanic_advisor.pages.modules.NavigationModule;
import com.mechanic_advisor.test_data_container.AppointmentType;
import com.mechanic_advisor.test_data_container.CalendarView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AppointmentManagementFeatureTests extends BaseTest {


    @BeforeMethod
    public void loginAndOpenCalendar() {
        loginPage = new LoginPage(driver);
        navigationModule = new NavigationModule(driver);
        calendarPage = new CalendarPage(driver);
        appointmentDialog = new AppointmentDialog(driver);
        appointmentDetailsDialog = new AppointmentDetailsDialog(driver);

        loginPage.login(userEmail, password);
        navigationModule.openCalendar(1);
        calendarPage.clickOnNewAppointmentButton();
    }

    @Test
    public void createNewAppointmentTest() {
        appointmentDialog.createNewAppointmentForToday(appointmentName, AppointmentType.DROPPING_OFF);
        calendarPage.selectCalendarPageView(CalendarView.DAY);

        assertTrue(calendarPage.isAppointmentForTodayPresentInCalendar(appointmentName),
                "Appointment " + appointmentName + " is not present in the calendar.");
    }

    @Test
    public void editAppointmentTest() {
        appointmentDialog.createNewAppointmentForToday(appointmentName, AppointmentType.DROPPING_OFF);
        calendarPage.selectCalendarPageView(CalendarView.DAY);
        calendarPage.openAppointmentDetailsDialog(appointmentName);
        appointmentDetailsDialog.openEditAppointmentDialog();
        appointmentDialog.editAppointmentNameAndType(updatedAppointmentName, AppointmentType.NONE);

        assertTrue(calendarPage.isAppointmentForTodayPresentInCalendar(updatedAppointmentName),
                "Updated appointment " + updatedAppointmentName + " is not present in the calendar.");

        calendarPage.openAppointmentDetailsDialog(updatedAppointmentName);

        assertTrue(appointmentDetailsDialog.isAppointmentOfTypeDisplayed(AppointmentType.NONE),
                "Appointment type was not updated.");
    }
}
