package org.assertions.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.waiters.WaitersStart;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Task4 {
    @Test
    public void checkRedirect() {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WaitersStart wait = new WaitersStart(driver);
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        WebElement checkBox = wait.waitForPresentElementLocatedBy(By.xpath("//input[@id='RememberMe']"));
        assertTrue(checkBox.isDisplayed());
        assertFalse(checkBox.isSelected(),"Чекбокс выбран, но не должен быть");
        checkBox.click();
        assertTrue(checkBox.isSelected(), "Чекбокс не выбран, а должен быть");
        checkBox.click();
        assertFalse(checkBox.isSelected(),"Чекбокс выбран, но не должен быть");
        driver.quit();
    }
}
