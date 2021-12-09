package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class SettingsTest extends BaseTest {
    @Test(description = "Checking the opening of the settings page", retryAnalyzer = Retry.class)
    public void checkSettingsPage() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsLink()
                .settingsPageShouldBeWorking();
    }

    @Test(description = "Choosing the German language", retryAnalyzer = Retry.class)
    public void setLanguageDeutsch() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setLanguage("de")
                .languageShouldBe("de");
    }

    @Test(description = "Choosing the France language", retryAnalyzer = Retry.class)
    public void setLanguageFrance() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setLanguage("fr")
                .languageShouldBe("fr");
    }

    @Test(description = "Choosing the Portugal language", retryAnalyzer = Retry.class)
    public void setLanguagePortugal() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setLanguage("pt")
                .languageShouldBe("pt");
    }

    @Test(description = "Changing the account password", retryAnalyzer = Retry.class)
    public void checkSetNewPass() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setMenuPass()
                .passShouldBeChanged(pass); //баг
    }

   @Test( description = "Changing the account password inactivity timeout")
    public void checkSetInactivityTimeout() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setInactivityTimeout("-1")
                .inactivityTimeoutShouldBeChanged("-1");
    }
}