package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class SettingsTest extends BaseTest {
    @Test(description = "Checking the opening of the settings page")
    public void checkSettingsPage() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsLink()
                .settingsPageShouldBeWorking();
    }

    @Test(description = "Choosing the German language")
    public void setLanguageDeutsch() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setLanguage("de")
                .languageShouldBe("de");
    }

    @Test(description = "Choosing the France language")
    public void setLanguageFrance() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setLanguage("fr")
                .languageShouldBe("fr");
    }

    @Test(description = "Choosing the Portugal language")
    public void setLanguagePortugal() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setLanguage("pt")
                .languageShouldBe("pt");
    }

    @Test(description = "Changing the account password")
    public void checkSetNewPass() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setMenuPass()
                .passShouldBeChanged(pass); //баг
    }
}