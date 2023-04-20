package org.driver_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DriveMetods3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();

        //driver.findElement(By.xpath("//a[text() = 'Apply now']")).click();

        ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//section[@class='footer-section'][3]//a")));
        Set<String> labels = new HashSet<>();
        for (int i = 0; i < links.size(); i++) {
            labels.add(links.get(i).getText());
        }

        System.out.println(labels.contains("Business & brand marketing solutions"));
        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
        }
        driver.quit();

        //links.forEach((webElement -> System.out.println(webElement.getText())));
    }
}

