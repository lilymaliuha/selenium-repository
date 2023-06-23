package mechanic_advisor_tests;

import com.mechanic_advisor.BrowserType;
import com.mechanic_advisor.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.createWebDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
        driver.get("https://dev2frontend.ngrok.io/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
