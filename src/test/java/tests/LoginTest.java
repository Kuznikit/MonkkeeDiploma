package tests;
import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {
   @Test(description = "", retryAnalyzer = Retry.class)
    public void openLoginPage (){
       loginPage
               .openLoginPage()
               .login(user, pass)
               .checkPageOpened();
   }
    @Test(description = "", retryAnalyzer = Retry.class)
    public void checkMandatoryField () {
        loginPage
                .openLoginPage()
                .login(user, "")
                .checkMandatoryField();
    }
    @Test(description = "", retryAnalyzer = Retry.class)
    public void checkRegistrationPage () {
        loginPage
                .openLoginPage()
                .openRegisterPage();
    }
    @Test(description = "", retryAnalyzer = Retry.class)
    public void checkRemindPage () {
        loginPage
                .openLoginPage()
                .openReminderPage();

    }
    @Test(description = "", retryAnalyzer = Retry.class)
    public void checkRemindPass () {
        loginPage
                .openLoginPage()
                .reminderPass(user);
    }
}
