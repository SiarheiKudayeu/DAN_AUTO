package org.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsWebClass2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //один из вариантов реализации drag n drop
        /*driver.get("https://www.ibuongiorno.com/about");
        Thread.sleep(5000);
        WebElement contacts = driver.findElement(By.xpath("//a[@data-namespace='contacts']"));
        WebElement logoLeft = driver.findElement(By.xpath("//a[@data-namespace='homepage']/img"));
        WebElement center = driver.findElement(By.xpath("//div[@class='c-dot']"));
        Actions actions = new Actions(driver);
        int y = center.getSize().height/2;
        for (int i =0; i<4;i++){
            actions.moveToElement(contacts,0,y).pause(5).clickAndHold().moveToElement(logoLeft,0,y).release().build().perform();
        }*/

        /*driver.get("https://www.signesduquotidien.org/");
        WebElement menu=driver.findElement(By.id("menu-btn"));
        menu.click();
        WebElement ouverture = driver.findElement(By.xpath("//span[text()='Ouverture']/parent::div"));
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.dragAndDrop(ouverture,menu).perform();*/

        //keyUp(), keyDown()
        driver.get("https://rozetka.com.ua/ua/mobile-phones/c80003/");
        WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement smartTvElectronik = driver.findElement(By.xpath("//span[text()='Смартфони, ТВ і електроніка']"));
        actions.keyDown(Keys.CONTROL)
                .moveToElement(smartTvElectronik).click()
                .pause(2)
                .click(smartTvElectronik)
                .keyUp(Keys.CONTROL)
                .click(smartTvElectronik).build().perform();





    }
}
