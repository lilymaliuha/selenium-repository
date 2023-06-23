package mechanic_advisor_tests;

import com.mechanic_advisor.BrowserType;
import com.mechanic_advisor.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    Dotenv dotenv = Dotenv.load();
    public String baseUrl = dotenv.get("BASE_URL");
    public String userName = System.getProperty("userName");
    public String password = System.getProperty("password");

    protected WebDriver driver;

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
