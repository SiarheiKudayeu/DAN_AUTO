package org.waiters;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsingExpectedConditions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        //visibilityOfElementLocated(), frameToBeAvailableAndSwitchToIt(), alertIsPresent()
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookies = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accept-choices']")));
        acceptCookies.click();
        wait.until(ExpectedConditions.
                frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='iframeResult']")));
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();*/

        //elementToBeClickable(), elementSelectionStateToBe(),
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='RememberMe']")));
        *//*WebElement userNameField = driver.findElement(By.xpath("//input[@id='Username']"));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkBox,true));
        userNameField.sendKeys("Хомяк");
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkBox,false));
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password");*//*
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='Username']"));
        wait.until(ExpectedConditions.elementToBeSelected(checkBox));
        userNameField.sendKeys("Хомяк");
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkBox,false));
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password");*/

        //textToBePresentInElementValue(), presenceOfElementLocated(), titleIs(), titleContains()
        //textToBePresentInElement(), invisibilityOf().
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Username']")));
        wait.until(ExpectedConditions.textToBePresentInElementValue(userNameField,"Хомяк"));
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password");
        driver.get("https://uhomki.com.ua/");
        wait.until(ExpectedConditions.invisibilityOf(userNameField));

        wait.until(ExpectedConditions.titleIs("\"У Хомки\" Интернет-зоомагазин | Днепр, пр. А. Поля, 59. (остановка \"Медтехника\")"));
        wait.until(ExpectedConditions.titleContains("\"У Хомки\""));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//a[@href='/ru/oplata-i-dostavka/']")));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Оплата и доставка"));
        System.out.println(driver.getTitle());









    }
}
