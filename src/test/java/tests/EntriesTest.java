package tests;
import org.testng.annotations.Test;
import utils.Retry;

public class EntriesTest extends BaseTest {
    String entryTextFaker = faker.RandomEntryText();

    @Test(description = "Creating a new entry")
    public void createNewEntry() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntry("My first entry")
                .entryShouldBe("My first entry");
    }

    @Test(description = "Creating a new entry and deleting")
    public void deleteLastEntry() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntryFakerStyle(entryTextFaker)
                .deleteLastEntry()
                .entriesShouldBeDeleted();
    }

    @Test(description = "Creating new entries and deleting via checkbox all")
    public void deleteAllEntries() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntryFaker(entryTextFaker)
                .newEntryFaker(entryTextFaker)
                .newEntryFaker(entryTextFaker)
                .deleteAllEntries()
                .entriesShouldBeDeleted();
    }

    @Test(description = "Entry search")
    public void searchEntry () {
        loginPage.openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntryFaker(entryTextFaker)
                .newEntry("My third entry")
                .searchEntryShouldBe("My")
                .deleteAllEntries();
    }
}
