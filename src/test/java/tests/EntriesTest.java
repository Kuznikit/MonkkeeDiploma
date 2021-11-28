package tests;
import org.testng.annotations.Test;
import utils.Retry;

public class EntriesTest extends BaseTest {

    @Test(description = "", retryAnalyzer = Retry.class)
    public void createNewEntry() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntries("My first entry");
    }

    @Test(description = "", retryAnalyzer = Retry.class)
    public void deleteLastEntry() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntries("My first entry")
                .deleteLastEntry();
    }

    @Test(description = "", retryAnalyzer = Retry.class)
    public void deleteAllEntries() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage.newEntry("My first entry")
                .newEntry("My second entry")
                .newEntry("My third entry")
                .deleteAllEntries();
    }

    @Test(description = "", retryAnalyzer = Retry.class)
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
