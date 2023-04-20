package org.elements;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.waiters.WaitersStart;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Elements {
    protected final WebDriver driver;
    protected WaitersStart waiters;
    static final Logger logger = LoggerFactory.getLogger(Elements.class);
    public Elements(WebDriver driver){
        this.driver=driver;
        waiters= new WaitersStart(driver);
    }

    public WebElement findElement(By by){
        WebElement element=null;
        try {
            logger.info("Trying to find element with locator "+by.toString()+".");
            waiters.waitForPresentElementLocated(by);
            element=driver.findElement(by);
            return element;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            element=null;
            return element;
        }finally {
            if(element==null){
                logger.error("Can't find element with locator "+by.toString()+".");
            }
        }
    }
    public List<WebElement> findElements(By by){
        List<WebElement> elements=null;
        try {
            logger.info("Trying to find elements with locator "+by.toString()+".");
            waiters.waitForPresentElementLocated(by);
            elements=driver.findElements(by);
            return elements;
        }catch (NoSuchElementException e){
            elements=null;
            return elements;
        }finally {
            if (elements==null){
                logger.error("Can't find element with locator "+by.toString()+".");
            }
        }

    }
    public WebElement findElementByXpath(String xpath){
        try {
            waiters.waitForPresentElementLocated(By.xpath(xpath));
           return driver.findElement(By.xpath(xpath));
        }catch (NoSuchElementException e){
            return  null;
        }
    }
    public WebElement findElementByTextWithXpath(String text,String tagName){
        try {waiters.waitForPresentElementLocated
                (By.xpath("//"+tagName+"[text()='"+text+"']"));
            return findElementByXpath("//"+tagName+"[text()='"+text+"']");
        }catch (NoSuchElementException e){
            return  null;
        }
    }
    public WebElement findElementByPartTextWithXpath(String text,String tagName){
        try {
            waiters.waitForPresentElementLocated
                    (By.xpath("//"+tagName+"[contains(text(), '"+text+"')]"));
            return findElementByXpath("//"+tagName+"[contains(text(), '"+text+"')]");
        }catch (NoSuchElementException e){
            return  null;
        }
    }
    public String getElementText(WebElement element){
        logger.info("Getting text from element with locator.");
        return element.getText();
    }
    public String getElementText(By by){
        logger.info("Getting text from element with locator "+by.toString()+".");
        return findElement(by).getText();
    }
    public boolean elementHasText(WebElement element, String text){
        return getElementText(element).equals(text);
    }
    public boolean elementHasText(By by, String text){
        return getElementText(findElement(by)).equals(text);
    }
    public String getAttributeElement(By by, String attribute){
        logger.info("Getting attribute"+attribute+" from element with locator "+by.toString()+".");
        return findElement(by).getAttribute(attribute);
    }
    public String getAttributeElement(WebElement element, String attribute){
        logger.info("Getting attribute"+attribute+" from element.");
        return element.getAttribute(attribute);
    }
    public String getTagElement(By by){
        return findElement(by).getTagName();
    }
    public String getTagElement(WebElement element){
        return element.getTagName();
    }
    public WebElement getFirstElementFromList(By by){
        try {
           List<WebElement> elements= findElements(by);
           return elements.get(0);
        }catch (NullPointerException e){
            return null;
        }
    }
    public WebElement getLastElementFromList(By by){
        try {
            List<WebElement> elements= findElements(by);
            return elements.get(elements.size()-1);
        }catch (NullPointerException e){
            return null;
        }
    }
    public WebElement getElementFromListByIndex(By by, int index){
        try {
            List<WebElement> elements= findElements(by);
            return elements.get(index);
        }catch (NullPointerException e){
            return null;
        }
    }


    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | NullPointerException ex) {
            return false;
        }
    }
    public boolean isElementDisplayed(By by) {
        logger.info("Returning boolean of element to be displayed "+isElementDisplayed(findElement(by))+".");
        return isElementDisplayed(findElement(by));
    }



    public boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (NoSuchElementException | NullPointerException ex) {
            return false;
        }
    }
    public boolean isElementEnabled(By by) {
        return isElementEnabled(findElement(by));
    }



    public boolean isElementSelected(WebElement element) {
        try {
            return element.isSelected();
        } catch (NoSuchElementException | NullPointerException ex) {
            return false;
        }
    }
    public boolean isElementSelected(By by) {
        return isElementSelected(findElement(by));
    }
    public int getIntValueFromElement(By by){
        return Integer.parseInt(findElement(by).getText());
    }
    public int getIntValueFromElement(WebElement element){
        return Integer.parseInt(element.getText());
    }

}
