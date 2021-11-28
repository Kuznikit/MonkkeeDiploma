package tests;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
   @Test(description = "")
    public void openLoginPage (){
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        loginPage.checkPageOpened();
    }
    @Test(description = "")
    public void checkMandatoryField (){
        loginPage.openLoginPage();
        loginPage.login(user,"");
        loginPage.checkMandatoryField();
    }
    @Test(description = "")
    public void checkRegistrationPage (){
        loginPage.openLoginPage();
        loginPage.openRegisterPage();
    }
    @Test(description = "")
    public void checkRemindPage (){
        loginPage.openLoginPage();
        loginPage.openReminderPage();

    }
    @Test(description = "")
    public void checkRemindPass (){
        loginPage.openLoginPage();
        loginPage.reminderPass(user);
}
}
