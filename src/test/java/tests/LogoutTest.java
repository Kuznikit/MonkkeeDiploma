package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class LogoutTest extends BaseTest{
    @Test(description = "Check logout from Account")
    public void checkLogout (){
        loginPage
                .openLoginPage()
                .login(user, pass)
                .logout()
                .logoutShouldBeWorking();
    }
}
