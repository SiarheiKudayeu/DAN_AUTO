package org.actions_separate;

import org.elements.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Actions {
    static final Logger logger = LoggerFactory.getLogger(Actions.class);
    protected final Elements elements;
    protected final org.openqa.selenium.interactions.Actions actions;
    protected  final WebDriver driver;
    public Actions(WebDriver driver){
        this.driver=driver;
        elements = new Elements(driver);
        actions = new org.openqa.selenium.interactions.Actions(driver);
    }
    public void clickOnElement(By by){
        logger.info("Clicking on element with locator "+by+".");
        elements.findElement(by).click();
    }
    public void clickOnElement(WebElement element){
        actions.click();
    }
    public void doubleClickOnElement(By by){
        logger.info("Double click on element with locator "+by+".");
        actions.moveToElement(elements.findElement(by)).doubleClick().build().perform();
    }
    public void doubleClickOnElement(WebElement element){
        actions.moveToElement(element).doubleClick().build().perform();
    }
    public void contextClickOnElement(By by){
        logger.info("Context click on element with locator "+by+".");
        actions.moveToElement(elements.findElement(by)).contextClick().build().perform();
    }
    public void contextClickOnElement(WebElement element){
        actions.moveToElement(element).contextClick().build().perform();
    }
    public void dragNDropElement(By startLocator,By targetLocator){
        logger.info("Trying to move element "+elements.findElement(startLocator).getText()+
                "to position of element "+ elements.findElement(targetLocator).getText());
        actions.dragAndDrop(elements.findElement(startLocator),
                elements.findElement(targetLocator)).perform();
    }
    public void dragNDropElementLocation(WebElement element,int xLocation, int yLocation){
            actions.moveToElement(element).clickAndHold()
                    .moveByOffset(xLocation,yLocation).pause(2)
                    .release().build().perform();
    }
    public void dragNDropElement(WebElement startElement, WebElement targetElement){
        actions.dragAndDrop(startElement,targetElement).perform();
    }
    public void hoverElement(WebElement element){
        actions.moveToElement(element).perform();
    }
    public void hoverElement(By by){
        actions.moveToElement(elements.findElement(by)).perform();
    }
    public void hoverAndClickElement(WebElement element){
        actions.moveToElement(element).click().build().perform();
    }
    public void hoverAndClickElement(By by){
        actions.moveToElement(elements.findElement(by)).click().build().perform();
    }
    public void openLinkInNewTab(WebElement element){
        logger.info("Opening Link in a new Tab");
        actions.keyDown(Keys.CONTROL)
                .moveToElement(element).click()
                .pause(1)
                .keyUp(Keys.CONTROL)
                .build().perform();
    }
    public void openLinkInNewTab(By by){
        logger.info("Opening Link in a new Tab");
        actions.keyDown(Keys.CONTROL)
                .moveToElement(elements.findElement(by)).click()
                .pause(1)
                .keyUp(Keys.CONTROL)
                .build().perform();
    }
    public void openLinkInNewTabAndSwitch(WebElement element){
        logger.info("Opening Link in a new Tab and switching for it");
        Set<String> firstHandle = driver.getWindowHandles();
        openLinkInNewTab(element);
        Set<String> nextHandles = driver.getWindowHandles();
        nextHandles.removeAll(firstHandle);
        String newHandle = nextHandles.iterator().next();
        driver.switchTo().window(newHandle);

    }
    public void openLinkInNewTabAndSwitch(By by){
        logger.info("Opening Link in a new Tab and switching for it");
        Set<String> firstHandle = driver.getWindowHandles();
        openLinkInNewTab(by);
        Set<String> nextHandles = driver.getWindowHandles();
        nextHandles.removeAll(firstHandle);
        String newHandle = nextHandles.iterator().next();
        driver.switchTo().window(newHandle);
    }
    public void enterText(String text, WebElement element){
        logger.info("Sending text \""+text+"\" to Element");
        element.sendKeys(text);
    }
    public void enterText(String text, By by){

        logger.info("Sending text \""+text+"\" to Element with locator "+by.toString());
        elements.findElement(by).sendKeys(text);
    }
    public void clearText(WebElement element){
        element.clear();
    }
    public void clearText(By by){
        logger.info("Clearing text");
        elements.findElement(by).clear();
    }
    public void clearTextAndWriteNew(String text, WebElement element){
        clearText(element);
        enterText(text,element);
    }
    public void clearTextAndWriteNew(String text, By by){
        clearText(by);
        enterText(text,by);
    }
    public void enterTextAndSubmit(String text, WebElement element){
        element.sendKeys(text);
        element.submit();
    }
    public void enterTextAndSubmit(String text, By by){
        elements.findElement(by).sendKeys(text);
        elements.findElement(by).submit();
    }
    public void clearTextAndWriteNewSubmit(String text, WebElement element){
        clearText(element);
        enterText(text,element);
        element.submit();
    }
    public void clearTextAndWriteNewSubmit(String text, By by){
        clearText(by);
        enterText(text,by);
        elements.findElement(by).submit();
    }




}
