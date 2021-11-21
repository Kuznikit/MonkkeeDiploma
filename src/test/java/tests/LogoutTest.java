package tests;

import org.testng.annotations.Test;
import tests.base.Retry;

public class LogoutTest extends BaseTest{
    @Test(retryAnalyzer = Retry.class, description = "")
    public void checkLogout (){
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        loginPage.logout();
    }
}
