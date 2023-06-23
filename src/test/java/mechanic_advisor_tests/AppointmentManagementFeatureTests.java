package mechanic_advisor_tests;

import com.mechanic_advisor.pages.CalendarPage;
import com.mechanic_advisor.pages.LoginPage;
import com.mechanic_advisor.pages.dialogs.CreateNewAppointmentDialog;
import com.mechanic_advisor.pages.modules.NavigationModule;
import com.mechanic_advisor.test_data_container.AppointmentType;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AppointmentManagementFeatureTests extends BaseTest {

    @Test
    public void createNewAppointmentTest() {
        LoginPage loginPage = new LoginPage(driver);
        NavigationModule navigationModule = new NavigationModule(driver);
        CalendarPage calendarPage = new CalendarPage(driver);
        CreateNewAppointmentDialog newAppointmentDialog = new CreateNewAppointmentDialog(driver);

        loginPage.login("aqa.interview@mailinator.com", "P5vioN%jc&^b");
        navigationModule.openCalendar(1);
        calendarPage.clickOnNewAppointmentButton();
        newAppointmentDialog.createNewAppointmentForToday("New Appointment", AppointmentType.DROPPING_OFF);

        assertTrue(calendarPage.isAppointmentPresentInCalendar("New Appointment"),
                "Appointment is not present in the calendar.");
    }
}
