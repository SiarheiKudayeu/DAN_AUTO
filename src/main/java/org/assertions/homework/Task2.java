package org.assertions.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.waiters.WaitersStart;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Task2 {
    @Test
    public void checkRedirect() {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WaitersStart wait = new WaitersStart(driver);
        driver.get("https://uhomki.com.ua/ru/");
        WebElement element = wait.waitForPresentElementLocatedBy(By.xpath("//div[@class='header__wrapper']//a[text()='Оплата и доставка']"));
        element.click();
        wait.waitForPresentElementLocatedBy(By.xpath("//a[text()='Оплата и доставка'][@class='sideMenu-a']"));
        assertEquals(driver.getCurrentUrl(), "https://uhomki.com.ua/ru/oplata-i-dostavka/", "Неправильный редирект");
        driver.quit();
    }
}
