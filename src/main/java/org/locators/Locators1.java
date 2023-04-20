package org.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();*/

        //Поиск элемента по id
        //driver.findElement(By.id("search")).click();

        //Поиск элемента по name
        /*System.out.println(driver.findElement(By.name("Search")).getAttribute("name"));
        driver.quit();*/

        //Поиск элемента по Class Name
        //driver.findElement(By.className("green-background")).click();

        //Поиск элемента по Tag Name
        driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.id("ez-accept-all")).click();
        WebElement element = (driver.findElements(By.tagName("input"))).get(1);
        element.sendKeys("input");

        //Поиск элемента по Link Text
        //driver.findElement(By.linkText("APPLICATION PROCESS")).click();

        //Поиск элемента по Partial Text
        //driver.findElement(By.partialLinkText("APPLICATION")).click();

        //Xpath //имя_тега[@атрибут='значение']
        //driver.findElement(By.xpath("//div[@class='buttons-holder block block-4-12']")).click();

        //xpath поиск по тексту
        //driver.findElement(By.xpath("//a[text()='Standard application']")).click();

        //xpath поиск по части текста. Метод contains
        //driver.findElement(By.xpath("//a[contains(text(), 'Standard ')]")).click();

        //xpath поиск по части атрибута. комбинирование
        /*driver.findElement
                (By.xpath("//div[contains(@class,'block block-4-12')]" +
                        "[not(contains(@class, 'columned'))]")).click();*/

        //относительный путь внутри относительного пути
        /*driver.findElement
                (By.xpath("//section[@class='simple-intro-wrapper component-wrapper design-two']" +
                        "//a[text()='Apply now']")).click();*/

        //xpath передвижение по DOM дереву
        // /.. - вверх по тегу
        // /имя_тега вниз к указанному тегу
        //  переход на родительский тег /parent::div
        // переход на доченрний тег /child::a
        // переход на параллельный тег /following-sibling::*[1]
        // предок /ancestor::span
        // /descendant::h3
        /*driver.findElement(By.xpath("//a[text()='APPLICATION PROCESS']" +
                "/../../child::div/following-sibling::*[3]/a")).click();*/

        //xpath ключевые слово last(), указание порядкового номера
        //driver.findElement(By.xpath("//div[@class='columned block block-4-12'][last()]")).click();
        //driver.findElement(By.xpath("//div[@class='columned block block-4-12'][3]")).click();

        //xpath операторы >, <, >=, <=, !=
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.xpath("//input[@data-val-length-max>=255]")).sendKeys("Оператор >=");
        driver.findElement(By.xpath("//input[@data-val-length-max!=255]")).sendKeys("Оператор !=");*/











    }
}