package org.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Task2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        //select[@name='FromLB']
        //select[@name='ToLB']
        //select[@id='Carlist']
        //input[@onclick='move(this.form.FromLB,this.form.ToLB)']
        //input[@onclick='move(this.form.ToLB,this.form.FromLB)']
        Select selectCar = new Select(driver.findElement(By.xpath("//select[@id='Carlist']")));
        System.out.println("Автомобили доступные для выбора:");
        String result0= "";
        for(WebElement element:selectCar.getOptions()){
            result0=result0+element.getText()+", ";
        }
        String finalResult0 = result0+"\b\b.";
        System.out.println(finalResult0);
        selectCar.selectByVisibleText("Renault");

        Select selectFirst = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
        WebElement fromLeftToRight = driver.findElement(By.xpath("//input[@onclick='move(this.form.FromLB,this.form.ToLB)']"));
        WebElement fromRightToLeft = driver.findElement(By.xpath("//input[@onclick='move(this.form.ToLB,this.form.FromLB)']"));

        selectFirst.selectByVisibleText("Spain");
        selectFirst.selectByVisibleText("Italy");
        selectFirst.selectByVisibleText("France");
        selectFirst.selectByVisibleText("Germany");

        fromLeftToRight.click();
        System.out.println("Страны из первой таблицы: ");
        String result =  "";
        for(WebElement element:selectFirst.getOptions()){
            result = result+element.getText()+", ";
        }
        String finalResult = result+"\b\b.";
        System.out.println(finalResult);

        Select selectSecond = new Select(driver.findElement(By.xpath("//select[@name='ToLB']")));
        System.out.println("Страны из второй таблицы: ");
        String result2 =  "";
        for(WebElement element:selectSecond.getOptions()){
            result2 = result2+element.getText()+", ";
        }
        String finalResult2 = result2+"\b\b.";
        System.out.println(finalResult2);
        driver.quit();

    }
}
