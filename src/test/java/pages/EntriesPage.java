package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.testng.AssertJUnit.assertEquals;

public class EntriesPage extends BasePage {

    public static final By CREATE_ENTRIES_BUTTON = By.id("create-entry");
    public static final By DELETE_ENTRIES_BUTTON = By.id("delete-entries");
    public static final By BACK_TO_ENTRIES_PAGE_BUTTON = By.id("back-to-overview");
    public static final By EDITABLE_FIELD = By.cssSelector(".contenteditable.cke_editable");/*editable*/
    public static final By NEW_ENTRY = By.xpath("//*[contains(text(), 'My first entry')]");
    public static final By SAVE_NEW_ENTRY_BUTTON = By.cssSelector(".cke_button");
    public static final By SELECT_LAST_CHECKBOX = By.cssSelector("input[ng-model='model.checked[entry.id]']");
    public static final By SELECT_ALL_CHECKBOXES = By.cssSelector("input[ng-model='model.allChecked']");
    public static final By SEARCH_FIELD = By.id("appendedInputButton");


    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    public EntriesPage newEntries(String newEntryText) {

        driver.findElement(CREATE_ENTRIES_BUTTON).click();
        //driver.findElement(EDITABLE_FIELD).sendKeys(newEntryText);
        Actions action = new Actions(driver);
        action.click(driver.findElement(EDITABLE_FIELD)).sendKeys(newEntryText).perform();
        driver.findElement(SAVE_NEW_ENTRY_BUTTON).click();
        driver.findElement(BACK_TO_ENTRIES_PAGE_BUTTON).click();
        assertEquals("New entry has not been added", newEntryText,
                driver.findElement(NEW_ENTRY).getText());
        return new EntriesPage(driver);
    }

    public EntriesPage newEntry(String newEntryText) {

        driver.findElement(CREATE_ENTRIES_BUTTON).click();
        //driver.findElement(EDITABLE_FIELD).sendKeys(newEntryText);
        Actions action = new Actions(driver);
        action.click(driver.findElement(EDITABLE_FIELD)).sendKeys(newEntryText).perform();
        driver.findElement(SAVE_NEW_ENTRY_BUTTON).click();
        driver.findElement(BACK_TO_ENTRIES_PAGE_BUTTON).click();
        return new EntriesPage(driver);
    }

    public EntriesPage deleteLastEntry() {
        driver.findElement(SELECT_LAST_CHECKBOX).click();
        driver.findElement(DELETE_ENTRIES_BUTTON).click();
        driver.switchTo().alert().accept();
        return new EntriesPage(driver);
    }

    public EntriesPage deleteAllEntries() {
        driver.findElement(SELECT_ALL_CHECKBOXES).click();
        driver.findElement(DELETE_ENTRIES_BUTTON).click();
        driver.switchTo().alert().accept();
        return new EntriesPage(driver);
    }

    public EntriesPage searchEntry(String entryText) {
        driver.findElement(SEARCH_FIELD).sendKeys(entryText);
        driver.findElement(SEARCH_FIELD).submit();
        return new EntriesPage(driver);
    }

}