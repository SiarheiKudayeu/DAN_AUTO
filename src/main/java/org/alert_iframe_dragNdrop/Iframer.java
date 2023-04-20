package org.alert_iframe_dragNdrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Iframer {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe_frameborder_css");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accept = wait.until(presenceOfElementLocated(By.xpath("//div[@id = 'accept-choices']")));
        accept.click();

        wait.until(presenceOfElementLocated(By
                .xpath("//iframe[@id='iframeResult']")));
        WebElement frame = driver
                .findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(frame);

        wait.until(presenceOfElementLocated(By
                                .xpath("//p[text()='An iframe with default borders:']/following-sibling::iframe[1]")));
        WebElement frame2 = driver
                .findElement(By.xpath("//p[text()='An iframe with default borders:']/following-sibling::iframe[1]"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();


    }
}
