package org.assertions.homework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.waiters.WaitersStart;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Task5 {
    @Test
    public void checkRedirect() {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WaitersStart wait = new WaitersStart(driver);
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait.waitForPresentElementLocatedBy(By.xpath("//input[@value='Show Me Alert']"));
        alert.click();
        Alert alertBox = wait1.until(ExpectedConditions.alertIsPresent());
        assertEquals(alertBox.getText(), "Hi.. This is alert message!", "Алерта с таким текстом " + alertBox.getText() + " не присутствует");
        alertBox.accept();
        assertEquals(driver.getTitle(), "Only Testing: TextBox");
        driver.quit();
    }
}
