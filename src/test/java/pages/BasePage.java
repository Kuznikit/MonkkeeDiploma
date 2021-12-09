package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//повесить retry через anatation transormer
public class BasePage {
    public static final By CREATE_ENTRY = By.id("create-entry");
    public static final By POPUP_WINDOW =  By.cssSelector(".modal-content");
    public static final By POPUP_SUBMIT = By.xpath("//*[text()='Cancel']");
    public static final By POPUP_SUBMIT2 = By.cssSelector("[class=btn-text-content]");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public void popupLoginSubmit(){

        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_WINDOW));
        }catch (TimeoutException exception) {
            driver.findElement(POPUP_SUBMIT2).click();
        }
    }
  /*  public void popupLogoutSubmit(){
        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(POPUP_WINDOW));
        }catch (TimeoutException exception) {
            driver.findElement(POPUP_LOGOUT_SUBMIT).submit();

        }
    }*/
}
