package tests;
import org.testng.annotations.Test;
import utils.Retry;

public class EntriesTest extends BaseTest {
    String entryText = faker.RandomEntryText();
//вынести проверки на уровень тестов
//redme.md
//    добавить логирование
//    степы не добавлять
//спрятать логин и пароль
//            добавить проверку записи и менять текст с обычного на красивый (курсив, жирный)
    @Test(description = "Creating a new entry", retryAnalyzer = Retry.class)
    public void createNewEntry() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntry("My first entry")
                .entryShouldBe("My first entry");
    }

    @Test(description = "Creating a new entry and deleting", retryAnalyzer = Retry.class)
    public void deleteLastEntry() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntryFaker(entryText)
                .deleteLastEntry()
                .entriesShouldBeDeleted();
    }

    @Test(description = "Creating new entries and deleting via checkbox all", retryAnalyzer = Retry.class)
    public void deleteAllEntries() {
        loginPage
                .openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntryFaker(entryText)
                .newEntryFaker(entryText)
                .newEntryFaker(entryText)
                .deleteAllEntries()
                .entriesShouldBeDeleted();
    }

    @Test(description = "Entry search", retryAnalyzer = Retry.class)
    public void searchEntry () {
        loginPage.openLoginPage()
                .login(user, pass);
        entriesPage
                .newEntryFaker(entryText)
                .newEntryFaker(entryText)
                .newEntry("My third entry")
                .searchEntryShouldBe("My")
                .deleteAllEntries();
    }
}
