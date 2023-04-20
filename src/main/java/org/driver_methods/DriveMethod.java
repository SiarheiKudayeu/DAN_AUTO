package org.driver_methods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class DriveMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //manage() активируем вызов цепочки методов для настройки нашего драйвера
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        //driver.manage().getCookies();
        driver.get("https://rozetka.com.ua/ua/");
        //System.out.println(driver.manage().getCookies());
        Set<Cookie> set = driver.manage().getCookies();
        /*for(Cookie cookie:set){
            System.out.println(cookie);
            System.out.println("++++++++++");
        }*/
        System.out.println(set.toArray().length);
        System.out.println(set.toArray()[7].toString());
        System.out.println("============");
        System.out.println(set.toArray()[7]);


        //Получить информацию о куках
        /*Set<Cookie> set = driver.manage().getCookies();
        Object[] string = set.toArray();
        String[] string2 = new String[string.length];
        for(int i =0;i<string.length;i++){
            string2[i]=string[i].toString();
        }
        for (String cookie:string2){
            System.out.println(cookie);
        }
        System.out.println(string2[6]);
        System.out.println("");*/

        //get() загрузка новой веб страницы в текущем окне
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/ua/");
        driver.get("https://dan-it.com.ua/program/kiev/java/");
        driver.get("https://www.guinnessworldrecords.com/");*/

        //getCurrentUrl() получить Url текущей страницы
        /*driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println("ссылка нашей страницы "+driver.getCurrentUrl());*/

        //getTitle() получить название текущей страницы
        /*driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println("Имя нашей страницы \n\""+driver.getTitle()+"\"");*/

        //getPageSource() получить структуру нашей страницы
        /*driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println(driver.getPageSource());*/

        //quit() закрывает драйвер
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/program/kiev/java/");
        System.out.println("Имя нашей страницы \n\""+driver.getTitle()+"\"");
        driver.quit();

    }
}
