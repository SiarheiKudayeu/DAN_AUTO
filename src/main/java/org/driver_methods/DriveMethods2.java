package org.driver_methods;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

public class DriveMethods2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //navigate() позволяет переключаться назад, вперед, а также по указанному адресу
        /*driver.get("https://dan-it.com.ua/program/kiev/java/");
        driver.findElement(By.xpath("//a[text() = 'О нас']")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(4000);
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.quit();*/

        /*driver.get("https://dan-it.com.ua/program/kiev/java/");
        //открытие новой вкладки
        ((JavascriptExecutor)driver).executeScript("window.open()");
        driver.get("https://www.dogsavenue.com.ua/");
        //Но переход все равно осуществляется в предыдущем окне
        //getWindowHandles - позволяет получить дескрипторы окна
        ArrayList<String> descrypt = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(descrypt.get(1));
        driver.get("https://www.dogsavenue.com.ua/");*/

        //Второй вариант для получения дескриптера нового окна
        driver.get("https://dan-it.com.ua/program/kiev/java/");
        String first = driver.getWindowHandle();
        Set<String> firstHandle = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> nextHandles = driver.getWindowHandles();
        nextHandles.removeAll(firstHandle);
        String newHandle = nextHandles.iterator().next();
        driver.switchTo().window(newHandle);
        driver.get("https://www.dogsavenue.com.ua/");
        driver.switchTo().window(first);
        driver.get("https://www.guinnessworldrecords.com/");
        //close() закрывает активное окно
        driver.close();
        //Для проверки с каким окном все же работает после закрытия драйвер
        driver.switchTo().window(newHandle);
        driver.get("https://www.guinnessworldrecords.com/");


    }
}
