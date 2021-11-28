package tests;

import org.testng.annotations.Test;


public class SettingsTest extends BaseTest {
    @Test(description = "")
    public void checkSettingsPage() {
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        settingsPage.setLink();
    }

    @Test(description = "")
    public void setLangDE() {
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        settingsPage.openSettings();
        settingsPage.setLangDE();
    }

    @Test(description = "")
    public void setLangEN() {
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        settingsPage.openSettings();
        settingsPage.setLangEN();
    }

    @Test(description = "")
    public void setLangFR() {
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        settingsPage.openSettings();
        settingsPage.setLangFR();
    }

    @Test(description = "")
    public void setLangPT() {
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        settingsPage.openSettings();
        settingsPage.setLangPT();
    }

    @Test(description = "")
    public void checkSetNewPass() {
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        settingsPage.openSettingsByButton();
        settingsPage.setMenuPass(pass);
    }
    @Test(description = "")
    public void checkSetInactivityTimeout() {
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        settingsPage.openSettingsByButton();
        settingsPage.setInactivityTimeout();

    }

}