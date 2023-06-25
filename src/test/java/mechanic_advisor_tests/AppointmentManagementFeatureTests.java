package mechanic_advisor_tests;


import com.mechanic_advisor.pages.CalendarPage;
import com.mechanic_advisor.pages.LoginPage;
import com.mechanic_advisor.pages.dialogs.AppointmentDetailsDialog;
import com.mechanic_advisor.pages.dialogs.AppointmentDialog;
import com.mechanic_advisor.pages.dialogs.DeleteAppointmentDialog;
import com.mechanic_advisor.pages.modules.NavigationModule;
import com.mechanic_advisor.test_data_container.CalendarView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AppointmentManagementFeatureTests extends BaseTest {

    @BeforeMethod
    public void loginAndOpenCalendar() {
        loginPage = new LoginPage(driver);
        navigationModule = new NavigationModule(driver);
        calendarPage = new CalendarPage(driver);
        appointmentDialog = new AppointmentDialog(driver);
        appointmentDetailsDialog = new AppointmentDetailsDialog(driver);
        deleteAppointmentDialog = new DeleteAppointmentDialog(driver);

        loginPage.login(userEmail, password);
        navigationModule.openCalendar(1);
        calendarPage.clickOnNewAppointmentButton();
    }

    @Test
    public void createNewAppointmentTest() {
        appointmentDialog.createAppointmentWithMandatoryFieldsForToday(newAppointmentData);
        calendarPage.selectCalendarPageView(CalendarView.DAY);

        assertTrue(calendarPage.isAppointmentForTodayPresentInCalendar(newAppointmentData.getAppointmentTitle()),
                "Appointment " + newAppointmentData.getAppointmentTitle() + " is not present in the calendar.");
    }

    @Test
    public void editAppointmentTest() {
        appointmentDialog.createAppointmentWithMandatoryFieldsForToday(newAppointmentData);
        calendarPage.selectCalendarPageView(CalendarView.DAY);
        calendarPage.openAppointmentDetailsDialog(newAppointmentData.getAppointmentTitle());
        appointmentDetailsDialog.openEditAppointmentDialog();
        appointmentDialog.editAppointmentNameAndType(updatedAppointmentData);

        assertTrue(calendarPage.isAppointmentForTodayPresentInCalendar(updatedAppointmentData.getAppointmentTitle()),
                "Updated appointment " + updatedAppointmentData.getAppointmentTitle() + " is not present in the calendar.");

        calendarPage.openAppointmentDetailsDialog(updatedAppointmentData.getAppointmentTitle());

        assertTrue(appointmentDetailsDialog.isAppointmentOfTypeDisplayed(updatedAppointmentData.getAppointmentType()),
                "Appointment type was not updated.");
    }

    @Test
    public void deleteAppointmentTest() {
        appointmentDialog.createAppointmentWithMandatoryFieldsForToday(appointmentData);
        calendarPage.selectCalendarPageView(CalendarView.DAY);
        calendarPage.openAppointmentDetailsDialog(appointmentData.getAppointmentTitle());
        appointmentDetailsDialog.openDeleteAppointmentDialog();
        deleteAppointmentDialog.deleteAppointment();

        assertFalse(calendarPage.isAppointmentForTodayPresentInCalendar(appointmentData.getAppointmentTitle()),
                "Appointment " + appointmentData.getAppointmentTitle() + " was not deleted.");
    }
}
