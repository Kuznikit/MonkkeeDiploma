package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import models.EntryFaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import pages.EntriesPage;
import pages.LoginPage;
import pages.SettingsPage;

import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    EntriesPage entriesPage;
    SettingsPage settingsPage;
    EntryFaker faker = new EntryFaker();
    String user; //= PropertyReader.getProperty("monkkee.user");
    String pass; //= PropertyReader.getProperty("monkkee.pass");

    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        user = System.getenv().getOrDefault("MONKKEE_USER", PropertyReader.getProperty("monkkee.user"));
        pass = System.getenv().getOrDefault("MONKKEE_PASS", PropertyReader.getProperty("monkkee.pass"));
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // if (browser.equals("chrome")) {
        //     WebDriverManager.chromedriver().setup();
//
        //       driver = new ChromeDriver();
        //  } else if (browser.equals("opera")) {
        //     WebDriverManager.operadriver().setup();
        //     driver = new OperaDriver();
        // }
        //  context.setAttribute("driver", driver);
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        entriesPage = new EntriesPage(driver);
        settingsPage = new SettingsPage(driver);
        faker = new EntryFaker();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }
}
