package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SettingsPage extends BasePage {
    public static final By DROPDOWN = By.name("selectLocale"); //class="form-control ng-pristine ng-valid"
    public static final By DROPDOWN_TIMEOUT = By.name("autoLogout");
    public static final By SETTINGS_LINK = By.cssSelector(".icon-cog.icon-light");
    private static final String SETTINGS_PAGE_URL = "https://my.monkkee.com/#/settings/locale";
    public static final By DE = By.xpath("//*[contains(text(), 'Sprachauswahl')]");
    public static final By EN = By.xpath("//*[contains(text(), 'Language selection')]");
    public static final By FR = By.xpath("//*[contains(text(), 'Sélection de la langue')]");
    public static final By PT = By.xpath("//*[contains(text(), 'Seletor de idiomas')]");
    public static final By MENU_PASS = By.cssSelector("[ng-class=\"cssClass('password')\"]"); //ng-class="cssClass('password')
    //By.cssSelector("li[ng-class='cssClass('password')']");
    //public static final By MENU_PASS = By.cssSelector("cssClass('password')");;
    public static final By MENU_TIMEOUT = By.cssSelector("[ng-class=\"cssClass('logout')\"]");
    public static final By OLD_PASS = By.id("old-password");
    public static final By NEW_PASS = By.id("password");
    public static final By NEW_CONF = By.id("password-confirmation");
    public static final By NEW_HINT = By.id("password-hint");
    public static final By PASS_CHANGED = By.xpath("//*[contains(text(), 'Your password has been changed successfully')]");
    public static final By TIMEOUT_CHANGED = By.xpath("//*[contains(text(), 'Your settings have been saved successfully')]");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void setLink() {
        driver.findElement(SETTINGS_LINK).click();
        assertTrue("Setting link doesn't work",
                driver.findElement(EN).isDisplayed());
    }

    public void openSettings() {
        driver.get(SETTINGS_PAGE_URL);
    }

    public void openSettingsByButton() {
        driver.findElement(SETTINGS_LINK).click();

    }


    public void setLangDE() {
        Select select = new Select(driver.findElement(DROPDOWN));
        select.selectByIndex(0);
        driver.findElement(DROPDOWN).submit();
        assertEquals("Set Lang doesn't work", "Sprachauswahl",
                driver.findElement(DE).getText());
        Select selectDef = new Select(driver.findElement(DROPDOWN));
        selectDef.selectByIndex(1);
        driver.findElement(DROPDOWN).submit();
    }

    public void setLangEN() {
        Select select = new Select(driver.findElement(DROPDOWN));
        select.selectByIndex(1);
        driver.findElement(DROPDOWN).submit();
        assertEquals("Set Lang doesn't work", "Language selection",
                driver.findElement(EN).getText());
    }

    public void setLangFR() {
        Select select = new Select(driver.findElement(DROPDOWN));
        select.selectByIndex(2);
        driver.findElement(DROPDOWN).submit();
        assertEquals("Set Lang doesn't work", "Sélection de la langue",
                driver.findElement(FR).getText());
        Select selectDef = new Select(driver.findElement(DROPDOWN));
        selectDef.selectByIndex(1);
        driver.findElement(DROPDOWN).submit();
    }

    public void setLangPT() {
        Select select = new Select(driver.findElement(DROPDOWN));
        select.selectByIndex(3);
        driver.findElement(DROPDOWN).submit();
        assertEquals("Set Lang doesn't work", "Seletor de idiomas",
                driver.findElement(PT).getText());
        Select selectDef = new Select(driver.findElement(DROPDOWN));
        selectDef.selectByIndex(1);
        driver.findElement(DROPDOWN).submit();
    }

    public void setLangDefault() {
        Select select = new Select(driver.findElement(DROPDOWN));
        select.selectByIndex(1);
        driver.findElement(DROPDOWN).submit();

    }

    public void setMenuPass(String pass) {
        driver.findElement(MENU_PASS).click();
        driver.findElement(OLD_PASS).sendKeys(pass);
        driver.findElement(NEW_PASS).sendKeys(pass);
        driver.findElement(NEW_CONF).sendKeys(pass);
        driver.findElement(NEW_HINT).sendKeys(pass);
        driver.findElement(NEW_HINT).submit();
        assertEquals("Pass doesn't change, something wrong", "Your password has been changed successfully",
                driver.findElement(PASS_CHANGED).getText());
    }

    public void setInactivityTimeout() {
        driver.findElement(MENU_TIMEOUT).click();
        Select select = new Select(driver.findElement(DROPDOWN_TIMEOUT));
        select.selectByIndex(0);
        driver.findElement(DROPDOWN_TIMEOUT).submit();
        assertEquals ("Timeout doesn't change, something wrong", "Your settings have been saved successfully",
                driver.findElement(TIMEOUT_CHANGED).getText());

    }
}
