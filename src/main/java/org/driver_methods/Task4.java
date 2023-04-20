package org.driver_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task4 {
    //Написать метод, который будет выводить в консоль тексты всех
    //элементов, которые можно найти по заданнму параметру.
    //Например при помощи него можно будет получить значения всех элементов
    // из списков заданных на рисунках.
    public static void getAllElementsText(List<WebElement> webElements) {
        for (WebElement webElement : webElements) {
            System.out.println(webElement.getText());
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        getAllElementsText(driver.findElements(By.xpath("//a[@class='products-menu__title-link']")));
        System.out.println("=============");
        getAllElementsText(driver.findElements(By.xpath("//div[@class='footer__heading'][text()='Клиентам']/following-sibling::ul/li")));
        System.out.println("=============");
        getAllElementsText(driver.findElements(By.xpath("//div[@class='footer__heading'][text()='Каталог']/following-sibling::ul/li")));
        driver.quit();
    }
}

