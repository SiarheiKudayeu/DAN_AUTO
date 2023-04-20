package org.waiters;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitsBegin {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Неявные ожидания
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Неявное ожиданиние загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Неявное ожидание отработки скриптов
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://zoomagazin.dp.ua/ua");
        //Явные ожидания ExplicitWait. Для вызова используем класс ExpectedConditions
        // а также класс WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[@title='Відгуки']")));
        WebElement voices = driver.findElement(By.xpath("//a[@title='Відгуки']"));
        voices.click();
        WebElement element =  wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[@title='Відгуки']")));
        //Свободные ожидания FluentWait
        FluentWait<WebDriver> fluentwait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        fluentwait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[@title='Акції та знижки']")));
        driver.findElement(By.xpath("//a[@title='Акції та знижки']")).click();

        //Thread.sleep просто задаем время ожидания
        try {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[@title='Уцінка']")).click();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
