package org.driver_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    //Написать метод который выводит сообщение об айди элемента,
    //значении тэга элемента , значении класса элемента,
    //значении атрибута name элемента, текста данного элемента,
    //а также о координатах центра контейнера данного элемента.
    //Создать свой тип исключений, который будет вызываться если у элемента
    //нет определенного атрибута и на экран будет выводиться сообщение об отсутствии данного атрибута.

    public static void getAtributes(WebElement element) throws NoSuchAttributeException {
        System.out.println("Название тега: "+ element.getTagName());
            if (element.getAttribute("id")==null) {
                throw new NoSuchAttributeException("Атриута айди не найдено");
            }else {
                System.out.println("Название айди "+ element.getAttribute("id"));
            }
        if (element.getAttribute("class")==null) {
            throw new NoSuchAttributeException("Атриута класс не найдено");
        }else {
            System.out.println("Название класса "+ element.getAttribute("class"));
        }
        if (element.getAttribute("name")==null) {
            throw new NoSuchAttributeException("Атриута имя не найдено");
        }else {
            System.out.println("Название атрибута name "+ element.getAttribute("name"));
        }


    }
    public static void getInfo(WebElement element){
        try {
            getAtributes(element);
        } catch (NoSuchAttributeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Координаты центра данного элемента: \n x: "+
                element.getLocation().x+element.getSize().width/2);
        System.out.println(" y: "+
                element.getLocation().y+element.getSize().height/2);
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        WebElement element1= driver.findElement(By.xpath("//span[text()='Вход'][@class='userbar__button-text']"));
        getInfo(element1);
        driver.quit();
    }


}
