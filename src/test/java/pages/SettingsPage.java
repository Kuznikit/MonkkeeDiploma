package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
@Log4j2
public class SettingsPage extends BasePage {
    public static final By DROPDOWN = By.name("selectLocale");
    public static final By DROPDOWN_TIMEOUT = By.name("autoLogout");// ng-pristine ng-valid
    public static final By DROPDOWN_TIMEOUT2 = By.cssSelector(".form-control.ng-pristine.ng-valid");
    public static final By SETTINGS_LINK = By.cssSelector(".icon-cog.icon-light");
    public static final By SETTINGS_BUTTON = By.cssSelector("[class=user-menu-btn]");
    public static final By EN = By.xpath("//*[contains(text(), 'Language selection')]");
    public static final By SETTINGS_MENU = By.id("settings-menu");
    public static final By MENU_PASS = By.cssSelector("[ng-class=\"cssClass('password')\"]");
    public static final By MENU_TIMEOUT = By.cssSelector("[ng-class=\"cssClass('logout')\"]");
    public static final By MENU_LANG = By.cssSelector("[ng-class=\"cssClass('locale')\"]");
    public static final By OLD_PASS = By.id("old-password");
    public static final By NEW_PASS = By.id("password");
    public static final By NEW_CONF = By.id("password-confirmation");
    public static final By NEW_HINT = By.id("password-hint");
    public static final By PASS_CHANGED = By.xpath("//*[contains(text(), 'Your password has been changed successfully')]");
    public static final By TIMEOUT_CHANGED = By.xpath("//*[contains(text(), 'Your settings have been saved successfully')]");
    public static final By OK_BUTTON = By.cssSelector("[class=btn-text-content]");
    public static final By CONFIRM = By.cssSelector(".alert");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public SettingsPage openSettingsLink() {
        log.info("Opening the settings page via the link");
        driver.findElement(SETTINGS_LINK).click();
       return new SettingsPage(driver);
    }

    public void settingsPageShouldBeWorking() {
        log.info("Checking the opening of the settings page via the link");
        driver.findElement(SETTINGS_LINK).click();
        assertTrue("Setting link doesn't work",
                driver.findElement(EN).isDisplayed());
        new SettingsPage(driver);
    }

    public SettingsPage openSettingsByButton() {
        log.info("Opening the settings page");
        driver.findElement(SETTINGS_BUTTON).click();
        return new SettingsPage(driver);
    }

    public SettingsPage setLanguage(String lang) {
        log.info("Language selection \"" + lang + "\"");
        Select select = new Select(driver.findElement(DROPDOWN));
        select.selectByValue(lang);
        driver.findElement(DROPDOWN).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM));
        System.out.println(driver.findElement(DROPDOWN).getAttribute("value"));

        return new SettingsPage(driver);
    }
    public SettingsPage languageShouldBe(String lang) {
        log.info("checking that the language is selected \"" + lang + "\"");
        driver.findElement(DROPDOWN).getAttribute("value");
        assertEquals(driver.findElement(DROPDOWN).getAttribute("value"), lang);
        Select select2 = new Select(driver.findElement(DROPDOWN));
        select2.selectByValue("en");
        driver.findElement(DROPDOWN).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM));
        return new SettingsPage(driver);
    }

    public SettingsPage setMenuPass() {
        log.info("Opening a menu with password settings");
        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(SETTINGS_MENU));
        }catch (TimeoutException exception) {
            driver.findElement(MENU_PASS).click();
        }
        return new SettingsPage(driver);
    }

    public void passShouldBeChanged(String pass) {
        log.info("Entering data to change the password");
        driver.findElement(OLD_PASS).sendKeys(pass);
        driver.findElement(NEW_PASS).sendKeys(pass);
        driver.findElement(NEW_CONF).sendKeys(pass);
        driver.findElement(NEW_HINT).sendKeys(pass);
        driver.findElement(NEW_HINT).submit();
        log.info("Checking that the password has been changed successfully");
        assertEquals("Pass doesn't change, something wrong", "Your password has been changed successfully",
                driver.findElement(PASS_CHANGED).getText());
        new SettingsPage(driver);
    }

    public SettingsPage setInactivityTimeout(String value) {
        log.info("Opening a menu with timeout settings");
        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(MENU_TIMEOUT));
        }catch (TimeoutException exception) {
            driver.findElement(DROPDOWN_TIMEOUT).click();
        }
        log.info("Changing the timeout settings");
       // wait.until(ExpectedConditions.visibilityOfElementLocated(DROPDOWN_TIMEOUT));
        System.out.println(driver.findElement(DROPDOWN_TIMEOUT).getText());

        Select select3 = new Select(driver.findElement(DROPDOWN_TIMEOUT2));
        select3.selectByValue(value);
        driver.findElement(DROPDOWN_TIMEOUT2).submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM));
        System.out.println(driver.findElement(DROPDOWN_TIMEOUT2).getAttribute("value"));

        //assertEquals(driver.findElement(DROPDOWN).getAttribute("value"), lang);
        return new SettingsPage(driver);
    }
    public void inactivityTimeoutShouldBeChanged(String value) {
        log.info("Checking that the timeout has been changed successfully");
        assertEquals("Timeout doesn't change, something wrong", value,
                driver.findElement(DROPDOWN_TIMEOUT).getAttribute("value"));
    }
}
