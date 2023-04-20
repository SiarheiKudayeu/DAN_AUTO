package org.assertions.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.waiters.WaitersStart;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task1 {
    @Test
    public void checkCountOfpages(){
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WaitersStart wait = new WaitersStart(driver);
        driver.get("https://dan-it.com.ua/uk/");
        WebElement hover = wait
                .waitForPresentElementLocatedBy(By.xpath
                        ("//li[@class='menu-item menu-item-type-taxonomy menu-item-object-programs-category menu-item-has-children menu-item-50667 header__nav-item']//a[@href='https://dan-it.com.ua/uk/program/adults/']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hover).perform();



        actions.keyDown(Keys.CONTROL).moveToElement(driver.findElement(By.xpath("//a[text()='FrontEnd']")))
                .click().moveToElement(driver.findElement(By.xpath("//a[text()='Java']"))).click()
                .moveToElement(driver.findElement(By.xpath("//a[text()='Quality Assurance (QA)']")))
                .click().keyUp(Keys.CONTROL).build().perform();
        assertTrue(driver.getWindowHandles().size()==4,
                "Фактическое количество страниц равно "+driver.getWindowHandles().size()+
                        ". Ожидаемое кол-во страниц 4.");
        driver.quit();
    }
}
