package org.waiters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.actions_separate.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class WaitersStart {
    static final Logger logger = LoggerFactory.getLogger(WaitersStart.class);
    public  WaitersStart(WebDriver driver){
        this.driver=driver;
    }

    private static final long IMPLICITLY_WAIT = 20L;
    private static final long EXPLICITLY_WAIT = 10L;
    private final WebDriver driver;
    /*private static WebDriver initialDriver(){
        return  new ChromeDriver();
    }*/
    /*public static WebDriver getDriver(){
        if(driver==null){
            driver=initialDriver();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
    }
    public static void openInputPage(String webpage){
        getDriver().get(webpage);
    }
    public static void setDriver(){
        getDriver().manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }*/


    private  void waitForFunction(Function function, Long timeOutInSeconds) {
        logger.info("Waiting for function");
        FluentWait<WebDriver> wait = fluentWaiter(timeOutInSeconds);
        wait.until(function);
    }

    public void waitForVisibilityOf(WebElement webElement) {
        waitForFunction(ExpectedConditions.visibilityOf(webElement),EXPLICITLY_WAIT);
    }
    public  void waitForVisibilityOf(By by) {
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)),EXPLICITLY_WAIT);
    }
    public WebElement waitForVisibilityOfElement(WebElement webElement) {
        return fluentWaiter(EXPLICITLY_WAIT).until(ExpectedConditions.visibilityOf(webElement));
    }
    public WebElement waitForVisibilityOfElement(By by) {
        logger.info("Waiting for visability of element located by "+by.toString());
        return fluentWaiter(EXPLICITLY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public  void waitForElementBeClickable(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeClickable(element),EXPLICITLY_WAIT);
    }
    public  void waitForElementBeClickable(By by) {
        waitForFunction(ExpectedConditions
                .elementToBeClickable(driver
                        .findElement(by)),EXPLICITLY_WAIT);
    }

    public  WebElement waitForElementToBeClickable(WebElement element) {
        return fluentWaiter(EXPLICITLY_WAIT).until(elementToBeClickable(element));
    }
    public WebElement waitForElementToBeClickable(By by) {
        return fluentWaiter(EXPLICITLY_WAIT)
                .until(elementToBeClickable(driver.findElement(by)));
    }
    public void waitForPresentElementLocated(By by) {
        logger.info("Waiting for present of element located by "+by.toString());
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by),EXPLICITLY_WAIT);
    }
    public WebElement waitForPresentElementLocatedBy(By by) {
        return fluentWaiter(EXPLICITLY_WAIT)
                .until(presenceOfElementLocated(by));
    }
    public ArrayList<WebElement> waitForPresentElementsLocatedAndReturnArrayList(By by) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by),EXPLICITLY_WAIT);
        return new ArrayList<>(driver.findElements(by));
    }

    public  WebElement waitForElementToBeClickable(MobileElement element, Long duration) {
        return  fluentWaiter(duration).until(elementToBeClickable(element));
    }
    public  WebElement waitForElementToBeClickable(By by, Long duration) {
        return  fluentWaiter(duration)
                .until(elementToBeClickable(driver.findElement(by)));
    }
    public  void waitForElementToDissapear(WebElement element){
        waitForFunction(ExpectedConditions.invisibilityOf(element),EXPLICITLY_WAIT);
    }
    public  void waitForElementToDissapear(By by){
        waitForFunction(ExpectedConditions.
                invisibilityOf(driver.findElement(by)),EXPLICITLY_WAIT);
    }
    public void waitCurrentSeconds(int seconds){
        logger.info("Waiting for "+seconds+" seconds");
        int miliseconds = seconds*1000;
        try {
            Thread.sleep(miliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void waitForAlert() {
        waitForFunction(ExpectedConditions.alertIsPresent(),EXPLICITLY_WAIT);
    }
    private FluentWait<WebDriver> fluentWaiter(Long duration) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }



    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver1.manage().window().maximize();
        driver1.get("https://zoomagazin.dp.ua/ua");
        WaitersStart waiters = new WaitersStart(driver1);
        waiters.waitForVisibilityOfElement(By.xpath("//a[@title='Відгуки']")).click();
        waiters.waitForPresentElementLocated(By.xpath("//a[@title='Акції та знижки']"));
        WebElement sales = driver1.findElement(By.xpath("//a[@title='Акції та знижки']"));
        waiters.waitForVisibilityOfElement(sales).click();
        waiters.waitCurrentSeconds(5);
        driver1.quit();
    }
}
