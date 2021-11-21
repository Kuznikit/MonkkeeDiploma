package tests;
import org.testng.annotations.Test;

public class EntriesTest extends BaseTest {

    @Test(description = "")
    public void createNewEntry (){
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        entriesPage.newEntries("My first entry");
    }
    @Test(description = "")
    public void deleteLastEntry (){
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        entriesPage.newEntries("My first entry");
        entriesPage.deleteLastEntry();
    }
    @Test(description = "")
    public void deleteAllEntries (){
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        entriesPage.newEntry("My first entry");
        entriesPage.newEntry("My second entry");
        entriesPage.newEntry("My third entry");
        entriesPage.deleteAllEntries();
    }

    @Test(description = "")
    public void searchEntry (){
        loginPage.openLoginPage();
        loginPage.login(user, pass);
        entriesPage.newEntry("My first entry");
        entriesPage.newEntry("My second entry");
        entriesPage.newEntry("My third entry");
        entriesPage.searchEntry("My");
        entriesPage.deleteAllEntries();
    }


}
