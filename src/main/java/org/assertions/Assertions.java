package org.assertions;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import org.actions_separate.Actions;
import org.elements.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.waiters.WaitersStart;

import java.util.List;

public class Assertions {
    protected  final Actions actions;
    protected final WebDriver driver;
    protected final WaitersStart waiters;
    protected final Elements elements;

    public Assertions(WebDriver driver){
        this.driver=driver;
        actions = new Actions(driver);
        elements = new Elements(driver);
        waiters= new WaitersStart(driver);
    }
    public void equals(int actualNumber, int expectedNumber){
        assertEquals(actualNumber,expectedNumber,"Expected value "+expectedNumber
        +" doesn't match actual value "+actualNumber);
    }
    public void equals(String actualValue, String expectedValue){
        assertEquals(actualValue,expectedValue,"Expected value "+expectedValue
                +" doesn't match actual value "+actualValue);
    }
    public void notEquals(String actualValue, String expectedValue){
        assertNotEquals(actualValue,expectedValue,"Expected value "+expectedValue
                +" match actual value "+actualValue+". But it shouldn't");
    }
    public  void elementIsDisplayed(By by){
        assertTrue(elements.isElementDisplayed(by), "Element is not displayed");
    }
    public  void elementIsDisplayed(WebElement element){
        assertTrue(elements.isElementDisplayed(element), "Element is not displayed");
    }
    public  void elementIsNotDisplayed(By by){
        assertFalse(elements.isElementDisplayed(by), "Element is displayed, but it shouldn't");
    }
    public  void elementIsNotDisplayed(WebElement element){
        assertFalse(elements.isElementDisplayed(element), "Element is not displayed, but it shouldn't");
    }

    public void elementHaveText(WebElement element, String text){
        elementIsDisplayed(element);
        equals(elements.getElementText(element),text);
    }
    public void elementHaveText(By by, String text){
        elementIsDisplayed(by);
        equals(elements.getElementText(by),text);
    }
    public void elementDoNotHaveText(WebElement element, String text){
        elementIsDisplayed(element);
        notEquals(elements.getElementText(element),text);
    }
    public void elementDoNotHaveText(By by, String text){
        elementIsDisplayed(by);
        notEquals(elements.getElementText(by),text);
    }
    public void elementHaveAttribute(WebElement element,String attributeName, String text){
        elementIsDisplayed(element);
        equals(elements.getAttributeElement(element,attributeName),text);
    }
    public void elementHaveAttribute(By by, String attributeName,String text){
        elementIsDisplayed(by);
        equals(elements.getAttributeElement(by,attributeName),text);
    }
    public void elementTagIs(WebElement element, String text){
        elementIsDisplayed(element);
        equals(elements.getTagElement(element),text);
    }
    public void elementTagIs(By by, String text){
        elementIsDisplayed(by);
        equals(elements.getTagElement(by),text);
    }
    public void assertUrl(String url){
        assertEquals(driver.getCurrentUrl(),url, "url is incorrect");
    }
    public void asserPagaTitle(String pageTitle){
        assertEquals(driver.getTitle(),pageTitle, "Page Title doesn't match expcted");
    }
    public  void elementIsEnabled(WebElement element){
        assertTrue(elements.isElementEnabled(element));
    }
    public  void elementIsEnabled(By by){
        assertTrue(elements.isElementEnabled(by));
    }
    public  void elementIsNotEnabled(WebElement element){
        assertFalse(elements.isElementEnabled(element),"Element is enabled, but it shouldn't");
    }
    public  void elementIsNotEnabled(By by){
        assertFalse(elements.isElementEnabled(by), "Element is enabled, but it shouldn't");
    }

    public  void elementIsSelected(WebElement element){
        assertTrue(elements.isElementSelected(element));
    }
    public  void elementIsSelected(By by){
        assertTrue(elements.isElementSelected(by));
    }
    public  void elementIsNotSelected(WebElement element){
        assertFalse(elements.isElementSelected(element));
    }
    public  void elementIsNotSelected(By by){
        assertFalse(elements.isElementSelected(by));
    }
    public void listSizeIsEqual(List<?> elements, int expectedSize){
        assertEquals(elements.size(),expectedSize,"Size of list doesn't equal to "+expectedSize);
    }
    public void valueOfElementIspositive(By by){
        assertTrue(Integer.parseInt(elements.getElementText(by))>0);
    }
    public void valueOfElementIspositive(WebElement element){
        assertTrue(Integer.parseInt(elements.getElementText(element))>0);
    }
    public  void isCheckboxChecked(By by){
        assertTrue(Boolean.parseBoolean(elements.getAttributeElement(by,"checked")));
    }
    public  void checkCssValue(By by, String cssName, String cssExpectedValue){
        assertEquals(elements.findElement(by).getCssValue(cssName),cssExpectedValue);
    }
    public  void checkCssValue(WebElement element, String cssName, String cssExpectedValue){
        assertEquals(element.getCssValue(cssName),cssExpectedValue);
    }
}
