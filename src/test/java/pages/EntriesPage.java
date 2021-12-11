package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertEquals;

@Log4j2
public class EntriesPage extends BasePage {
    public static final By CREATE_ENTRIES_BUTTON = By.id("create-entry");
    public static final By DELETE_ENTRIES_BUTTON = By.id("delete-entries");
    public static final By BACK_TO_ENTRIES_PAGE_BUTTON = By.id("back-to-overview");
    public static final By EDITABLE_FIELD = By.cssSelector(".contenteditable.cke_editable");
    public static final By NEW_ENTRY = By.xpath("//*[contains(text(), 'My first entry')]");
    public static final By SAVE_NEW_ENTRY_BUTTON = By.cssSelector(".cke_button");
    public static final By SELECT_LAST_CHECKBOX = By.cssSelector("input[ng-model='model.checked[entry.id]']");
    public static final By SELECT_ALL_CHECKBOXES = By.cssSelector("input[ng-model='model.allChecked']");
    public static final By SEARCH_FIELD = By.id("appendedInputButton");
    public static final By BOLD_STYLE = By.cssSelector(".cke_button_icon.cke_button__bold_icon");
    public static final By NUM_STYLE = By.cssSelector(".cke_button_icon.cke_button__numberedlist_icon");
    public static final By MAXIMIZED_STYLE = By.cssSelector(".cke_button_icon.cke_button__simplemaximize_icon");

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Creating new entry with input text")
    public EntriesPage newEntry(String entryText) {
        driver.findElement(CREATE_ENTRIES_BUTTON).click();
        Actions action = new Actions(driver);
        action.click(driver.findElement(EDITABLE_FIELD))
                .sendKeys(entryText)
                .perform();
        log.info("Creating new entry with text \"" + entryText + "\"");
        driver.findElement(SAVE_NEW_ENTRY_BUTTON).click();
        driver.findElement(BACK_TO_ENTRIES_PAGE_BUTTON).click();
        return new EntriesPage(driver);
    }

    @Step("Checking the creation of the entry and the entered text")
    public EntriesPage entryShouldBe(String entryText) {
        log.info("Verifying that the entry with text \"" + entryText + "\" was created correctly");
        assertEquals("New entry has not been added", entryText,
                driver.findElement(NEW_ENTRY).getText());
       return new EntriesPage(driver);
    }

    @Step("Creating new entry with input text from faker")
    public EntriesPage newEntryFaker(String entryTextFaker) {
        log.info("Creating new entry with text \"" + entryTextFaker + "\"");
        driver.findElement(CREATE_ENTRIES_BUTTON).click();
        Actions action = new Actions(driver);
        action.click(driver.findElement(EDITABLE_FIELD))
                .sendKeys(entryTextFaker)
                .perform();
        driver.findElement(SAVE_NEW_ENTRY_BUTTON).click();
        driver.findElement(BACK_TO_ENTRIES_PAGE_BUTTON).click();
        return new EntriesPage(driver);
    }

    @Step("Creating new entry from faker with bold and num style")
    public EntriesPage newEntryFakerStyle(String entryTextFaker) {
        log.info("Creating new entry with text \"" + entryTextFaker + "\"");
        driver.findElement(CREATE_ENTRIES_BUTTON).click();
        Actions action = new Actions(driver);
        action.click(driver.findElement(EDITABLE_FIELD))
                .click(driver.findElement(MAXIMIZED_STYLE))
                .click(driver.findElement(BOLD_STYLE))
                .sendKeys(entryTextFaker)
                .click(driver.findElement(NUM_STYLE))
                .sendKeys(Keys.ENTER)
                .sendKeys(entryTextFaker)
                .click(driver.findElement(MAXIMIZED_STYLE))
                .perform();
        driver.findElement(SAVE_NEW_ENTRY_BUTTON).click();
        driver.findElement(BACK_TO_ENTRIES_PAGE_BUTTON).click();
        return new EntriesPage(driver);
    }

    @Step("Deleting the last creating entry")
    public EntriesPage deleteLastEntry() {
        log.info("Deleting las entry");
        driver.findElement(SELECT_LAST_CHECKBOX).click();
        driver.findElement(DELETE_ENTRIES_BUTTON).click();
        driver.switchTo().alert().accept();
        return new EntriesPage(driver);
    }

    @Step("Checking entry deletion")
    public EntriesPage entriesShouldBeDeleted() {
        log.info("Verifying that the entries was deleted correctly");
        try {
            driver.findElement(SELECT_LAST_CHECKBOX).isDisplayed();
        } catch (NoSuchElementException ex) {
            Assert.fail("Last entry doesn't deleted");
        }
        return new EntriesPage(driver);
    }

    @Step("Deleting all creating entry")
    public EntriesPage deleteAllEntries() {
        log.info("Deleting all entries");
        driver.findElement(SELECT_ALL_CHECKBOXES).click();
        driver.findElement(DELETE_ENTRIES_BUTTON).click();
        driver.switchTo().alert().accept();
        return new EntriesPage(driver);
    }

    @Step("Searching for an entry by the entered text")
    public EntriesPage searchEntryShouldBe(String entryText) {
        log.info("Searching entry with text \"" + entryText + "\"");
        driver.findElement(SEARCH_FIELD).sendKeys(entryText);
        driver.findElement(SEARCH_FIELD).submit();
        log.info("Verifying that the entry with text \"" + entryText + "\" has been found");
        return new EntriesPage(driver);
    }
}