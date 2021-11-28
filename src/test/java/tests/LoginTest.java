package tests;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
   @Test(description = "")
    public void openLoginPage (){
       loginPage
               .openLoginPage()
               .login(user, pass)
               .checkPageOpened();
   }
    @Test(description = "")
    public void checkMandatoryField () {
        loginPage
                .openLoginPage()
                .login(user, "")
                .checkMandatoryField();
    }
    @Test(description = "")
    public void checkRegistrationPage () {
        loginPage
                .openLoginPage()
                .openRegisterPage();
    }
    @Test(description = "")
    public void checkRemindPage () {
        loginPage
                .openLoginPage()
                .openReminderPage();

    }
    @Test(description = "")
    public void checkRemindPass () {
        loginPage
                .openLoginPage()
                .reminderPass(user);
    }
}
