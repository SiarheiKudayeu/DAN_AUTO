package org.webelement_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebElementMethods {

    static void clearAndSendKeys(WebDriver driver, String xpath, String text){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(text);
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element = driver.findElement(By.id("search-term"));
        element.sendKeys("Most handstand push ups in three minutes (male)");
        element.sendKeys(Keys.ENTER);*/

        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/ua/");
        WebElement element = driver.findElement(By.xpath("//input[@name='search']"));
        element.sendKeys("samsung");
        clearAndSendKeys(driver,"//input[@name='search']", "iPhone");*/






        //clear() удаляет значение из поля(элемента) если в него было что-то введено
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element = driver.findElement(By.id("search-term"));
        element.sendKeys("Most handstand push ups in three minutes (male)");
        Thread.sleep(2000);
        element.clear();
        Thread.sleep(2000);
        element.sendKeys("Most handstand push ups in three minutes (female)");
        element.sendKeys(Keys.ENTER);*/

        //getAttribute() получение значения атрибута элемента
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element = driver.findElement(By.id("search-term"));
        System.out.println(element.getAttribute("placeholder"));
        driver.close();*/

        //getCssValue() получение значения заданного свойства CSS
        driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element = driver.findElement(By.id("search-button"));
        System.out.println(element.getCssValue("text-transform"));
        driver.close();

        //getLocation() местонахождение верхнего левого угла элемента
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element1 = driver.findElement(By.id("search-term"));
        WebElement element2 = driver.findElement(By.id("search-button"));
        System.out.println(element1.getLocation());
        System.out.println(element2.getLocation());
        driver.close();*/

        //getSize() информация о ширине и высоте выбранного элемента
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element1 = driver.findElement(By.id("search-term"));
        WebElement element2 = driver.findElement(By.id("search-button"));
        System.out.println(element1.getSize());
        System.out.println(element2.getSize());
        driver.close();*/

        //getTagName() информация тэге выбранного элемента
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element1 = driver.findElement(By.id("search-term"));
        WebElement element2 = driver.findElement(By.id("search-button"));
        System.out.println(element1.getTagName());
        System.out.println(element2.getTagName());
        driver.close();*/

        //getText() получение текста внктри элемента
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element1 = driver.findElement(By.id("search-term"));
        WebElement element2 = driver.findElement(By.xpath("//span[@class='two-letter-iso-code']"));
        element1.sendKeys("То что я введу для получения текста в элементе");
        System.out.println("Текст первого элемента"+element1.getText());
        System.out.println("Текст второго элемента "+element2.getText());
        driver.close();*/

        //isDisplayed(), isEnabled(), isSelected()
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']")).click();
        WebElement element1 = driver.findElement(By.xpath("//input[@id='RememberMe']"));
        //WebElement element2 = driver.findElement(By.xpath("//span[text()='Please fill in the Email field.']"));
        System.out.println("отображается ли первый элемент? "+element1.isDisplayed());
        System.out.println("активирован ли первый элемент? "+element1.isEnabled());
        System.out.println("выбран ли первый элемент? "+element1.isSelected());
        element1.click();
        System.out.println("выбран ли первый элемент? "+element1.isSelected());
        driver.close();*/

        //submit() - подтверждает действие.
        /*driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Принять все']")).click();
        WebElement search = driver.findElement(By.xpath("//input[@title='Поиск']"));
        search.sendKeys("Тестировщик ПО");
        search.submit();*/
    }
}
