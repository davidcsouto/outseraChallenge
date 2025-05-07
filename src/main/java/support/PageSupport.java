package support;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import static support.Context.driver;

public class PageSupport {

    private final WebDriver driver;
    private static final Duration DEFAULTTIME = Duration.ofSeconds(30);

    public PageSupport(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    private WebDriverWait getWait(){
        return new WebDriverWait(driver(), DEFAULTTIME);
    }

    public String getPageTitle(){
        return driver().getTitle();
    }

    public WebElement waitElementToBeClickable(WebElement element){
        return this.getWait().withTimeout(DEFAULTTIME).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementToBeVisible(WebElement element){
        return this.getWait().withTimeout(DEFAULTTIME).until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement webElement){
        waitElementToBeClickable(webElement).click();
    }

    public void insertKeys(WebElement element, String value){
        waitElementToBeClickable(element).sendKeys(new CharSequence[]{(CharSequence) value});
    }

    public void hoverElement(WebElement element){
        WebElement elementHoverable = waitElementToBeVisible(element);
        new Actions(driver())
                .moveToElement(elementHoverable)
                .perform();
    }

    public void scrollToElement(WebElement element){
        waitElementToBeVisible(element);
        new Actions(driver())
                .scrollToElement(element)
                .perform();
    }

    public void selectOptionInSelectElement(WebElement selectElement, String textOption){
        Select select = new Select(selectElement);

        select.selectByVisibleText(textOption);
    }

    public void insertKeys(WebElement element, Keys value){
        waitElementToBeClickable(element).sendKeys(value);
    }

    public Boolean elementIsVisible(WebElement webElement){
        try{
            return webElement.isDisplayed();
        } catch (Exception ex){
            return false;
        }
    }

    public WebElement getItemInList(List<WebElement> elements, String value){
        Iterator<WebElement> it = elements.iterator();

        WebElement element;
        do {
            if (!it.hasNext()){
                return null;
            }
            element = (WebElement) it.next();
        } while (!element.isDisplayed() || !element.getText().equals(value));
        return element;
    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

    public void registerScreenshotAllureReport(String description){
        Allure.addAttachment(description, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void executeScript(WebElement element, String script){
        JavascriptExecutor js = (JavascriptExecutor) driver();
        js.executeScript(script, element);
    }
}
