package org.driver_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.waiters.WaitersStart;

public class Task5 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        WaitersStart waitersStart = new WaitersStart(driver);
        waitersStart.waitForPresentElementLocated
                (By.xpath("//input[@class='search__input']"));
        WebElement searc = driver.findElement
                (By.xpath("//input[@class='search__input']"));
        searc.sendKeys("Хорек");
        searc.submit();
        waitersStart.waitForPresentElementLocated(By.xpath("//a[contains(text(), 'Беафар ПАСТА')]"));
        driver.findElement(By.xpath("//a[contains(text(), 'Беафар ПАСТА')]")).click();

        waitersStart.waitForPresentElementLocated(By.xpath("//span[text()='К сравнению']"));
        driver.findElement(By.xpath("//span[text()='К сравнению']")).click();

        driver.findElement(By.xpath("//input[@class='search__input']")).sendKeys("Медведь");
        driver.findElement(By.xpath("//input[@class='search__input']")).submit();

        waitersStart.waitForPresentElementLocated(By.xpath("//a[contains(text(), 'Белый медведь')]"));
        driver.findElement(By.xpath("//a[contains(text(), 'Белый медведь')]")).click();

        waitersStart.waitForPresentElementLocated(By.xpath("//span[text()='К сравнению']"));
        driver.findElement(By.xpath("//span[text()='К сравнению']")).click();

        waitersStart.waitForPresentElementLocated(By.xpath("//span[text()='Сравнить']"));
        driver.findElement(By.xpath("//span[text()='Сравнить']")).click();

    }
}
