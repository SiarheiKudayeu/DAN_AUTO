package org.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selector2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");
        driver.findElement(By.xpath("//a[text()='Экскурсионные']")).click();
        Thread.sleep(2000);
        WebElement countryList = driver.findElement(By.id("country_list"));
        WebElement transportList = driver.findElement(By.id("transport_list"));
        WebElement cityFromList = driver.findElement(By.id("city_list"));
        WebElement cityToList = driver.findElement(By.id("tour_city_list"));

        Select country = new Select(countryList);
        Select transport = new Select(transportList);
        Select cityFrom = new Select(cityFromList);
        Select cityTo = new Select(cityToList);

        country.selectByVisibleText("Болгария");
        country.selectByVisibleText("Германия");
        country.selectByVisibleText("Греция");
        country.deselectByVisibleText("Австрия");
        List<WebElement> luist = country.getAllSelectedOptions();
        for(WebElement element:luist){
            System.out.println(element.getText());
        }

        Thread.sleep(3000);

        transport.selectByVisibleText("Автобус");
        Thread.sleep(3000);
        transport.deselectByVisibleText("Все виды");

        cityFrom.selectByVisibleText("Киев");
        Thread.sleep(3000);
        cityFrom.selectByVisibleText("Одесса");
        Thread.sleep(3000);
        cityFrom.deselectByIndex(0);

        cityTo.selectByVisibleText("Не имеет значения");

    }
}
