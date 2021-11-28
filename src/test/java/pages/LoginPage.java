package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public static final By LOGIN_BUTTON = By.cssSelector(".btn-text-content");
    public static final By POPUP_WINDOW =  By.cssSelector(".modal-content");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
        return new LoginPage(driver);
    }

    public LoginPage login(String user, String pass) {
        //      try {
        driver.findElement(LOGIN).sendKeys(user);
        driver.findElement(PASS).sendKeys(pass);
        driver.findElement(PASS).submit();
        popupLoginSubmit();
        //             } catch (Exception e) {
        //          popupLoginSubmit();
        //          wait.until(ExpectedConditions.elementToBeClickable(POPUP_SUBMIT));
        //           driver.findElement(POPUP_SUBMIT).click();
        //       }
        return new LoginPage(driver);

    }

    public LoginPage checkPageOpened() {
        assertTrue("Wrong username or password, you have to do something",
                driver.findElement(CREATE_ENTRY).isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage checkMandatoryField() {
        assertEquals("Mandatory field", "Mandatory field",
                driver.findElement(MANDATORY_ERROR).getText());
        return new LoginPage(driver);
    }

    public LoginPage openRegisterPage() {
        driver.findElement(REGISTER_LINK).click();
        assertTrue("The registration link doesn't work, you have to do something",
                driver.findElement(REGISTRATION).isDisplayed());
        return new LoginPage(driver);
    }
    public LoginPage openReminderPage() {
        driver.findElement(REMIND_LINK).click();
        assertTrue("The remind link doesn't work, you have to do something",
                driver.findElement(REMIND).isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage reminderPass(String user) {
        driver.findElement(REMIND_LINK).click();
        driver.findElement(LOGIN_REMIND).sendKeys(user);
        driver.findElement(LOGIN_REMIND).submit();
        assertEquals("you need to enter the correct login", "Password hint sent",
                driver.findElement(REMIND_DONE).getText());
        return new LoginPage(driver);
    }

    public LoginPage logout() {

  //      try {
            driver.findElement(LOGOUT_LINK).click();
            assertEquals("logout doesn't work","Send password reminder",
                    driver.findElement(REMIND_LINK).getText());
  //          popupLogoutSubmit();
  //      } catch (NoSuchElementException exception) {
   //         driver.findElement(LOGOUT_LINK_POPUP).click();
     //       assertTrue("logout from POP-up doesn't work",
     //               driver.findElement(REMIND_LINK).isDisplayed());
    //    }
        return new LoginPage(driver);
    }


}
