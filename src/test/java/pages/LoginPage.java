package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends BasePage {
    private static final String LOGIN_PAGE_URL = "https://my.monkkee.com/";
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
    public static final By LOGOUT_LINK_POPUP = By.xpath("//div[text()='Log out']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    public void login(String user, String pass) {
        driver.findElement(LOGIN).sendKeys(user);
        driver.findElement(PASS).sendKeys(pass);
        driver.findElement(PASS).submit();

    }

    public void checkPageOpened() {
        assertTrue("Wrong username or password, you have to do something",
                driver.findElement(CREATE_ENTRY).isDisplayed());
    }

    public void checkMandatoryField() {
        assertEquals("Mandatory field", "Mandatory field",
                driver.findElement(MANDATORY_ERROR).getText());
    }

    public void openRegisterPage() {
        driver.findElement(REGISTER_LINK).click();
        assertTrue("The registration link doesn't work, you have to do something",
                driver.findElement(REGISTRATION).isDisplayed());
    }
    public void openReminderPage() {
        driver.findElement(REMIND_LINK).click();
        assertTrue("The registration link doesn't work, you have to do something",
                driver.findElement(REMIND).isDisplayed());
    }

    public void reminderPass(String user) {
        driver.findElement(REMIND_LINK).click();
        driver.findElement(LOGIN_REMIND).sendKeys(user);
        driver.findElement(LOGIN_REMIND).submit();
        assertEquals("you need to enter the correct login", "Password hint sent",
                driver.findElement(REMIND_DONE).getText());
    }

    public void logout() {

        try {
            driver.findElement(LOGOUT_LINK).click();
            assertTrue("logout doesn't work",
                    driver.findElement(LOGIN).isDisplayed());

        } catch (NoSuchElementException exception) {
            driver.findElement(LOGOUT_LINK_POPUP).click();
            assertTrue("logout from POP-up doesn't work",
                    driver.findElement(LOGIN).isDisplayed());
        }
    }

}
