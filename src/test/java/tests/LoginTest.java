package tests;
import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {
   @Test(description = "Opening the login page with login and password", retryAnalyzer = Retry.class)
    public void openLoginPage (){
       loginPage
               .openLoginPage()
               .login(user, pass)
               .loginPageShouldBeOpened();
   }
    @Test(description = "Checking the required field to fill in", retryAnalyzer = Retry.class)
    public void checkMandatoryField () {
        loginPage
                .openLoginPage()
                .login(user, "")
                .mandatoryFieldShouldBeDisplayed();
    }
    @Test(description = "Checking the opening of the registration page", retryAnalyzer = Retry.class)
    public void checkRegistrationPage () {
        loginPage
                .openLoginPage()
                .registerPageShouldBeOpened();
    }
    @Test(description = "Checking the opening of the password reminder page", retryAnalyzer = Retry.class)
    public void checkRemindPage () {
        loginPage
                .openLoginPage()
                .reminderPageShouldBeOpened();

    }
    @Test(description = "Password recovery by email", retryAnalyzer = Retry.class)
    public void checkRemindPass () {
        loginPage
                .openLoginPage()
                .remindPass(user)
                .remindPassShouldBeSend();
    }
}
