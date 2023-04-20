package org.alert_iframe_dragNdrop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertsIframes {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            WebElement alertOk = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
            WebElement alertOkDismiss = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
            WebElement alertText = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
            WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
            //при возникновении модального окна неободимо на него переключиться
            //это можно сделать через метод switchTo() класса WebDriver
            System.out.println(result.getText()+" Это текст невидимого элемента");
            alertOk.click();
            //Alert alert = driver.switchTo().alert();
            //Либо можно переключится на alert при помощи WebDreiverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert =wait.until(ExpectedConditions.alertIsPresent());
            //geyText() получаем сообщение прописаннное в модальном окне
            System.out.println(alert.getText());
            //accept() нажимаем OK
            Thread.sleep(2000);
            alert.accept();
            System.out.println(result.getText());
            alertOkDismiss.click();
            System.out.println(alert.getText());
            Thread.sleep(2000);
            alert.dismiss();
            Thread.sleep(2000);
            System.out.println(result.getText());
            alertText.click();
            Thread.sleep(2000);
            alert.sendKeys("This is for Alert");
            Thread.sleep(2000);
            System.out.println(alert.getText());
            alert.accept();
            System.out.println(result.getText());
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }
}
