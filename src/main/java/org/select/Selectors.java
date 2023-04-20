package org.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Selectors {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");
//        WebElement transport = driver.findElement(By.id("transport_type"));
//        WebElement country = driver.findElement(By.id("itt_country"));
        WebElement hotelList = driver.findElement(By.id("hotel_list"));
        WebElement regionList = driver.findElement(By.id("region_list"));
        WebElement nutrition = driver.findElement(By.xpath("//select[@class='itt_nutrition_select']"));
//        WebElement nightFrom = driver.findElement(By.id("night_from"));
//        WebElement nightTill = driver.findElement(By.id("night_till"));
//        WebElement adult = driver.findElement(By.id("adult"));
//        WebElement children = driver.findElement(By.id("children"));
//        WebElement switchPrice = driver.findElement(By.id("switch_price"));

        //Для работы с дропдаунами необходимо создать объект класса Select
        //для получения возможности работаь с его методами

//        Select transportSelect = new Select(transport);
//        Select countrySelect = new Select(country);
        Select hotelListSelect = new Select(hotelList);
        Select regionListSelect = new Select(regionList);
        Select nutritionSelect = new Select(nutrition);
//        Select nightFromSelect = new Select(nightFrom);
//        Select nightTillSelect = new Select(nightTill);
//        Select adultSelect = new Select(adult);
//        Select childrenSelect = new Select(children);
//        Select switchSelect = new Select(switchPrice);

        //selectByVisibleText(); выбор элемента с определенным тесктом
        regionListSelect.selectByVisibleText("Кушадасы");
        regionListSelect.selectByVisibleText("Кемер");
        regionListSelect.selectByVisibleText("Аланья");
        regionListSelect.selectByVisibleText("Белек");

        //selectByValue() выбирает все элементы с заданным значением value
        Thread.sleep(2000);
        hotelListSelect.selectByValue("14006");
        hotelListSelect.selectByValue("307826");

        //selectByIndex() выбор элемента по индексу. Индексирование начинается с нуля;
//        nutritionSelect.selectByIndex(0);

        //deselectByVisibleText(), deselectByValue(), deselectByIndex(), deselectAll
        //отменяют выбор элемента в зависимости от параметра
        /*hotelListSelect.deselectByIndex(0);
        hotelListSelect.deselectByIndex(4);
        regionListSelect.deselectAll();*/

        //isMultiple(); возвращает true если данный select поддерживает множественный выбор
        /*System.out.println(hotelListSelect.isMultiple());
        System.out.println(nutritionSelect.isMultiple());*/

        //getOptions возвращает все элементы данного Select
        /*WebElement[]options = nutritionSelect.getOptions().toArray(new WebElement[0]);
        for (WebElement element:options){
            System.out.println(element.getText());
        }
        System.out.println("---------------------------------------------");
        List<WebElement>element = nutritionSelect.getOptions();
        for (WebElement element1:element){
            System.out.println(element1.getText());
        }*/

        //getAllSelectedOptions() возвращает все выбранные option из select
        /*regionListSelect.selectByIndex(2);
        regionListSelect.selectByIndex(3);
        regionListSelect.selectByIndex(4);
        regionListSelect.deselectByIndex(0);
        List<WebElement> web = regionListSelect.getAllSelectedOptions();
        for (WebElement element:web){
            System.out.println(element.getText());
        }*/
        //System.out.println("-----------------------------------");
        //getFirsSelectedOptions() возвращает первый выбранный элемент
        //System.out.println(regionListSelect.getFirstSelectedOption().getText());

        //equals сравнивание двух элементов
        System.out.println(regionListSelect.equals(hotelListSelect));




    }
}
