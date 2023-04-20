package org.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class ActionWebClass3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Frame
        WebElement frame = wait.until(ExpectedConditions
                .presenceOfElementLocated
                        (By.xpath("//iframe[@aria-label='Окно диспетчера конфиденциальности']")));
        driver.switchTo().frame(frame);
        WebElement accept = wait.until(ExpectedConditions
                .elementToBeClickable(
                        By.xpath("//span[text()='Принять всё']")));
        accept.click();
        WebElement contextClick = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions actions = new Actions(driver);
        //contextClick()
        actions.moveToElement(contextClick).contextClick().build().perform();
        driver.findElement(By.xpath("//span[text()='Quit']")).click();
        //Alert
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
        //doubleClick()
        WebElement doubleClick = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        actions.moveToElement(doubleClick).doubleClick().build().perform();
        Alert alert2 = wait.until(alertIsPresent());
        alert2.dismiss();


    }


}
