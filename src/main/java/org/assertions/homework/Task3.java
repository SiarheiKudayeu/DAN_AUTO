package org.assertions.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.waiters.WaitersStart;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Task3 {

    @Test
    public void checkRedirect() {
        String firstSearch = "смесь";
        String secondSearch = "спесь";
        String thirdSearch = "ересь";
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WaitersStart wait = new WaitersStart(driver);
        driver.get("https://uhomki.com.ua/ru/");
        WebElement search = wait.waitForPresentElementLocatedBy(By.xpath("//input[@placeholder='поиск товаров']"));
        search.sendKeys(firstSearch);
        search.submit();
        wait.waitForPresentElementLocated(By.xpath("//h1[@id='j-catalog-header']"));
        assertTrue((driver.findElement(By.xpath("//h1[@id='j-catalog-header']")).getText())
                .contains(firstSearch),"В результатах поиска нет указанного буквосочетания");

        wait.waitForPresentElementLocatedBy(By.xpath("//input[@placeholder='поиск товаров']"));
        driver.findElement(By.xpath("//input[@placeholder='поиск товаров']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='поиск товаров']")).sendKeys(secondSearch);
        driver.findElement(By.xpath("//input[@placeholder='поиск товаров']")).submit();

        wait.waitForPresentElementLocated(By.xpath("//h1[@id='j-catalog-header']"));
        assertTrue((driver.findElement(By.xpath("//h1[@id='j-catalog-header']")).getText())
                .contains(secondSearch),"В результатах поиска нет указанного буквосочетания");

        wait.waitForPresentElementLocatedBy(By.xpath("//input[@placeholder='поиск товаров']"));
        driver.findElement(By.xpath("//input[@placeholder='поиск товаров']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='поиск товаров']")).sendKeys(thirdSearch);
        driver.findElement(By.xpath("//input[@placeholder='поиск товаров']")).submit();

        wait.waitForPresentElementLocated(By.xpath("//h1[@id='j-catalog-header']"));
        assertTrue((driver.findElement(By.xpath("//h1[@id='j-catalog-header']")).getText())
                .contains(thirdSearch),"В результатах поиска нет указанного буквосочетания");

        driver.quit();
    }
}
