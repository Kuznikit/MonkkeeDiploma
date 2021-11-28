package tests;

import org.testng.annotations.Test;
import utils.Retry;


public class SettingsTest extends BaseTest {
    @Test(description = "", retryAnalyzer = Retry.class)
    public void checkSettingsPage() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .setLink();
    }

    @Test(description = "", retryAnalyzer = Retry.class)
    public void setLangDE() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettings()
                .setLangDE();
    }

    @Test(description = "", retryAnalyzer = Retry.class)
    public void setLangEN() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettings()
                .setLangEN();
    }

    @Test(description = "", retryAnalyzer = Retry.class)
    public void setLangFR() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage.openSettings()
                .setLangFR();
    }

    @Test(description = "", retryAnalyzer = Retry.class)
    public void setLangPT() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettings()
                .setLangPT();
    }

    @Test(description = "", retryAnalyzer = Retry.class)
    public void checkSetNewPass() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setMenuPass(pass);
    }
    @Test(description = "", retryAnalyzer = Retry.class)
    public void checkSetInactivityTimeout() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setInactivityTimeout();

    }

}