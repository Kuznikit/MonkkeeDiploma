package tests;

import org.testng.annotations.Test;
import tests.retry.Retry;

public class LogoutTest extends BaseTest{
    @Test(retryAnalyzer = Retry.class, description = "")
    public void checkLogout (){
        loginPage
                .openLoginPage()
                .login(user, pass)
                .logout();

    }
}
