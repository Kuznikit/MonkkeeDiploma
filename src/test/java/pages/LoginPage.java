package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
@Log4j2
public class LoginPage extends BasePage {
    private static final String LOGIN_PAGE_URL = "https://my.monkkee.com/#/";
    private static final By LOGIN = By.id("login");
    private static final By PASS = By.id("password");
    private static final By LOGIN_REMIND = By.id("email");
    private static final By REGISTER_LINK = By.xpath("//*[contains(text(), 'Register')]");
    private static final By REMIND_LINK = By.xpath("//*[contains(text(), 'Send password reminder')]");
    private static final By REGISTRATION = By.xpath("//*[contains(text(), 'Registration')]");
    private static final By REMIND = By.xpath("//*[contains(text(), 'Send yourself a password reminder')]");
    private static final By REMIND_DONE = By.xpath("//*[contains(text(), 'Password hint sent')]");
    public static final By MANDATORY_ERROR = By.xpath("//*[contains(text(), 'Mandatory field')]");
    public static final By LOGOUT_LINK = By.cssSelector("button[ng-click='logout($event)']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
        log.info("Opening login page");
        return new LoginPage(driver);
    }

    public LoginPage login(String user, String pass) {
        driver.findElement(LOGIN).sendKeys(user);
        driver.findElement(PASS).sendKeys(pass);
        driver.findElement(PASS).submit();
        popupLoginSubmit();
        log.info("Authorization with login and password");
        return new LoginPage(driver);
    }

    public void loginPageShouldBeOpened() {
        log.info("Verifying that the login and password correct");
        assertTrue("Wrong username or password, you have to do something",
                driver.findElement(CREATE_ENTRY).isDisplayed());
        new LoginPage(driver);
    }

    public LoginPage mandatoryFieldShouldBeDisplayed() {
        log.info("Verifying that the mandatory field should be filled in");
        assertEquals("Mandatory field", "Mandatory field",
                driver.findElement(MANDATORY_ERROR).getText());
       return new LoginPage(driver);
    }

    public LoginPage registerPageShouldBeOpened() {
        driver.findElement(REGISTER_LINK).click();
        log.info("Verifying that the register page opens");
        assertTrue("The registration link doesn't work, you have to do something",
                driver.findElement(REGISTRATION).isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage reminderPageShouldBeOpened() {
        driver.findElement(REMIND_LINK).click();
        log.info("Checking that the password reminder page opens");
        assertTrue("The remind link doesn't work, you have to do something",
                driver.findElement(REMIND).isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage remindPass(String user) {
        log.info("Password reminder via email");
        driver.findElement(REMIND_LINK).click();
        driver.findElement(LOGIN_REMIND).sendKeys(user);
        driver.findElement(LOGIN_REMIND).submit();
        log.info("Checking password recovery via email");
        assertEquals("you need to enter the correct login", "Password hint sent",
                driver.findElement(REMIND_DONE).getText());
        return new LoginPage(driver);
    }
    public void remindPassShouldBeSend() {
        log.info("Checking password recovery via email");
        assertEquals("you need to enter the correct login", "Password hint sent",
                driver.findElement(REMIND_DONE).getText());
    }
    public LoginPage logout() {
        log.info("Checking logout link");
        driver.findElement(LOGOUT_LINK).click();
        assertEquals("logout doesn't work", "Send password reminder",
                driver.findElement(REMIND_LINK).getText());
        return new LoginPage(driver);
    }
    public LoginPage logoutShouldBeWorking() {
        assertTrue("logout doesn't work",
                driver.findElement(LOGIN).isDisplayed());
        return new LoginPage(driver);
    }
}
