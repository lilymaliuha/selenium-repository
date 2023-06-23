package mechanic_advisor_tests;

import com.mechanic_advisor.BrowserType;
import com.mechanic_advisor.DriverManager;
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
    protected String appointmentName = "New Appointment" + Utils.getRandomNumber();

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Test data " + userEmail + " " + password);
        driver = DriverManager.createWebDriver(BrowserType.CHROME);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
