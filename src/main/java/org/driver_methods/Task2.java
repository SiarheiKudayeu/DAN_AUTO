package org.driver_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Task2 {
    //Написать метод в параметры которого принимаются два ВебЭлемента.
    //метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
    //какой из элементов располагается левее на странице,
    //а также какой из элементов занимает большую площадь.
    //Параметры метода могут также включать в себя другие аргументы, если это необходимо.

    static void webElementFight(WebElement element1, WebElement element2){
        if(element1.getLocation().y<element2.getLocation().y){
            System.out.println("Элемент "+element1.getText()+" расположен выше чем элемент "+element2.getText());
        } else {
            System.out.println("Элемент "+element2.getText()+" расположен выше чем элемент "+element1.getText());
        }
        if(element1.getLocation().x>element2.getLocation().x){
            System.out.println("Элемент "+element2.getText()+" расположен левее чем элемент "+element1.getText());
        } else {
            System.out.println("Элемент "+element1.getText()+" расположен левее чем элемент "+element2.getText());
        }
        if (element1.getSize().height*element1.getSize().width>element1.getSize().height*element1.getSize().width){
            System.out.println("Элемент "+element1.getText()+" занимает большую площадь чем "+element2.getText());
        } else {
            System.out.println("Элемент "+element2.getText()+" занимает большую площадь чем "+element1.getText());
        }
        }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        WebElement element1= driver.findElement(By.xpath("//span[text()='Вход'][@class='userbar__button-text']"));
                WebElement element2= driver.findElement
                        (By.xpath("//div[@class='products-menu__title']//a[contains(text(), 'Грызуны')]"));
                webElementFight(element1,element2);
                driver.close();
    }
    }

