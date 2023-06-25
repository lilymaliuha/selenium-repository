package mechanic_advisor_tests;

import com.mechanic_advisor.BrowserType;
import com.mechanic_advisor.DriverManager;
import com.mechanic_advisor.pages.CalendarPage;
import com.mechanic_advisor.pages.LoginPage;
import com.mechanic_advisor.pages.dialogs.AppointmentDetailsDialog;
import com.mechanic_advisor.pages.dialogs.AppointmentDialog;
import com.mechanic_advisor.pages.dialogs.DeleteAppointmentDialog;
import com.mechanic_advisor.pages.models.AppointmentModel;
import com.mechanic_advisor.pages.modules.NavigationModule;
import com.mechanic_advisor.test_data_container.AppointmentType;
import com.mechanic_advisor.utils.Utils;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    Dotenv dotenv = Dotenv.load();

    public String baseUrl = dotenv.get("BASE_URL");
//    public String userEmail = dotenv.get("USER_EMAIL");
//    public String password =  dotenv.get("PASSWORD");
    public String userEmail = System.getProperty("userEmail");
    public String password = System.getProperty("password");
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected NavigationModule navigationModule;
    protected CalendarPage calendarPage;
    protected AppointmentDialog appointmentDialog;
    protected AppointmentDetailsDialog appointmentDetailsDialog;
    protected DeleteAppointmentDialog deleteAppointmentDialog;
    protected AppointmentModel appointmentData = new AppointmentModel("Appointment" + Utils.getRandomNumber(), AppointmentType.WAITING);
    protected AppointmentModel newAppointmentData = new AppointmentModel("New Appointment" + Utils.getRandomNumber(), AppointmentType.DROPPING_OFF);
    protected AppointmentModel updatedAppointmentData = new AppointmentModel("Updated Appointment" + Utils.getRandomNumber(), AppointmentType.NONE);

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.createWebDriver(BrowserType.CHROME);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

