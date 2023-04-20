package org.driver_methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class Task1 {
    //Открыть пять различных страниц в новых окнах
    //https://uhomki.com.ua/ru/koshki/1074/
    //https://zoo.kiev.ua/
    //https://www.w3schools.com/
    //https://taxi838.ua/ru/dnepr/
    //https://klopotenko.com/
    //Прописать цикл, который будет переключаться поочередно через все страницы,
    //для каждой страницы выводить в консоль название и ссылку на эту страницу.
    //И будет закрывать ту страницу в названии которой есть слово зоопарк.
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ArrayList<String> windowHandles = new ArrayList<>();
        driver.get("https://uhomki.com.ua/ru/");
        windowHandles.add(driver.getWindowHandle());
        for(int i=0; i<4;i++){
            Set<String> firstHandle = driver.getWindowHandles();
            ((JavascriptExecutor)driver).executeScript("window.open()");
            Set<String> nextHandles = driver.getWindowHandles();
            nextHandles.removeAll(firstHandle);
            String nextHandle = nextHandles.iterator().next();
            windowHandles.add(nextHandle);
            driver.switchTo().window(nextHandle);
            if(i==0){
                driver.get("https://zoo.kiev.ua/");
            } else if(i==1){
                driver.get("https://www.w3schools.com/");
            }else if(i==2){
                driver.get("https://taxi838.ua/ru/dnepr/");
            }else if(i==3){
                driver.get("https://klopotenko.com/");
            }
        }
        for (int i = 0; i<windowHandles.size();i++){
            driver.switchTo().window(windowHandles.get(i));
            System.out.println("Ссылка на страницу: "+driver.getCurrentUrl());
            System.out.println("Название страницы: "+driver.getTitle());
            System.out.println("==============================");
            if(driver.getTitle().contains("зоопарк")){
                driver.close();
            }
        }




    }

}
