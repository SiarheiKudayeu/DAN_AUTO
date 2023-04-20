package org.actions;

import org.actions_separate.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.waiters.WaitersStart;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://www.ashortjourney.com/");
        WaitersStart waitersStart = new WaitersStart(driver);
        waitersStart.waitForPresentElementLocated( By.xpath(" //*[text()='DRAG']"));
        Actions actions = new Actions(driver);
        WebElement drageer = driver.findElement( By.xpath(" //*[text()='DRAG']"));
        WebElement locationToDrag = driver.findElement(By.xpath("//li[@id='ui-sound']"));
        actions.dragNDropElement(drageer,locationToDrag);

        Thread.sleep(4000);
        waitersStart.waitForPresentElementLocated(By.xpath(" //*[text()='DRAG']"));
        WebElement drageer2 = driver.findElement( By.xpath(" //*[text()='DRAG']"));
        WebElement locationToDrag2 = driver.findElement(By.xpath("//li[@id='ui-sound']"));
        actions.dragNDropElement(drageer2,locationToDrag2);

        Thread.sleep(4000);
        waitersStart.waitForPresentElementLocated(By.xpath(" //*[text()='DRAG']"));
        WebElement drageer3 = driver.findElement( By.xpath(" //*[text()='DRAG']"));
        WebElement locationToDrag3 = driver.findElement(By.xpath("//li[@id='ui-sound']"));
        actions.dragNDropElement(drageer3,locationToDrag3);

        Thread.sleep(4000);
        waitersStart.waitForPresentElementLocated(By.xpath("//*[text()='DRAG']"));
        WebElement drageer4 = driver.findElement( By.xpath("//*[text()='DRAG']"));
        WebElement locationToDrag4 = driver.findElement(By.xpath("//li[text()='CREDITS']"));
        actions.dragNDropElement(drageer4,locationToDrag4);

        Thread.sleep(4000);
        waitersStart.waitForPresentElementLocated(By.xpath("//*[text()='DRAG']"));
        WebElement drageer5 = driver.findElement( By.xpath("//*[text()='DRAG']"));
        waitersStart.waitForPresentElementLocated(By.xpath("//a[text()='a short journey']"));
        WebElement locationToDrag5 = driver.findElement(By.xpath("//a[text()='a short journey']"));
        System.out.println(locationToDrag5.getLocation());
        Thread.sleep(4000);
        actions.dragNDropElement(drageer5,locationToDrag5);
        /*org.openqa.selenium.interactions.Actions actions1 = new org.openqa.selenium.interactions.Actions(driver);
        actions1.moveToElement(drageer5).clickAndHold().moveToElement(locationToDrag5,-150,0)
                .release(drageer5).build().perform();*/

        Thread.sleep(4000);
        waitersStart.waitForPresentElementLocated(By.xpath("//*[text()='DRAG']"));
        WebElement drageer6 = driver.findElement( By.xpath("//*[text()='DRAG']"));
        WebElement locationToDrag6 = driver.findElement(By.xpath("//li[@id='ui-sound']"));
        actions.dragNDropElement(drageer6,locationToDrag6);

        Thread.sleep(4000);
        waitersStart.waitForPresentElementLocated(By.xpath("//*[text()='DRAG']"));
        WebElement drageer7 = driver.findElement( By.xpath("//*[text()='DRAG']"));
        WebElement locationToDrag7 = driver.findElement(By.xpath("//li[@id='ui-sound']"));
        System.out.println(locationToDrag7.getLocation());
        Thread.sleep(4000);
        org.openqa.selenium.interactions.Actions actions1 = new org.openqa.selenium.interactions.Actions(driver);
        actions1.moveToElement(drageer7).clickAndHold().moveToElement(locationToDrag7,0,-300)
                .release().build().perform();

        waitersStart.waitForPresentElementLocated(By.xpath("//*[@id='postcard-back-content']/textarea"));
        WebElement input = driver.findElement(By.xpath("//*[@id='postcard-back-content']/textarea"));
        input.sendKeys("Задание выполнено!");

    }
}
