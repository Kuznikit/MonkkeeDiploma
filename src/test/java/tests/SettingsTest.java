package tests;

import org.testng.annotations.Test;


public class SettingsTest extends BaseTest {
    @Test(description = "")
    public void checkSettingsPage() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .setLink();
    }

    @Test(description = "")
    public void setLangDE() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettings()
                .setLangDE();
    }

    @Test(description = "")
    public void setLangEN() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettings()
                .setLangEN();
    }

    @Test(description = "")
    public void setLangFR() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage.openSettings()
                .setLangFR();
    }

    @Test(description = "")
    public void setLangPT() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettings()
                .setLangPT();
    }

    @Test(description = "")
    public void checkSetNewPass() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setMenuPass(pass);
    }
    @Test(description = "")
    public void checkSetInactivityTimeout() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        settingsPage
                .openSettingsByButton()
                .setInactivityTimeout();

    }

}