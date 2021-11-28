package tests;
import org.testng.annotations.Test;

public class EntriesTest extends BaseTest {

    @Test(description = "")
    public void createNewEntry() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntries("My first entry");
    }

    @Test(description = "")
    public void deleteLastEntry() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntries("My first entry")
                .deleteLastEntry();
    }

    @Test(description = "")
    public void deleteAllEntries() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage.newEntry("My first entry")
                .newEntry("My second entry")
                .newEntry("My third entry")
                .deleteAllEntries();
    }

    @Test(description = "")
    public void searchEntry () {
        loginPage.openLoginPage()
                .login(user, pass);
        entriesPage.newEntry("My first entry")
                .newEntry("My second entry")
                .newEntry("My third entry")
                .searchEntry("My")
                .deleteAllEntries();
    }


}
