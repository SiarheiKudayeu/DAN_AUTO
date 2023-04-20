package org.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsWebClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/");

        //Для работы с классом Actions и его методами необходимо создать экземпляр
        //данного класса.
        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.xpath("//a[text()='Для взрослых']"));

        driver.findElement(By.xpath("//a[text()='Російська']")).click();

        int x = element.getLocation().getX()+(element.getSize().width)/2;
        int y = element.getLocation().getY()+(element.getSize().height)/2;

        System.out.println(element.getLocation());
        System.out.println(element.getSize());

        System.out.println(x);
        System.out.println(y)
        ;
        //moveByOffset() позволяет наводить курсор на элемент по координатам.
        actions.moveByOffset(x,y).build().perform();

        //moveToElement() позволяет наводить курсор на элемент.
        /*WebElement java = driver.findElement(By.xpath
                ("//a[text()='Для взрослых']/following-sibling::ul//a[text()='Java']"));
        actions.moveToElement(java).click().build().perform();*/

        //moveToElement(element, int xOffset, int yOffset) позволяет наводить курсор на элемент
        //относительно координат его центра
        /*WebElement java = driver.findElement(By.xpath
                ("//a[text()='Для взрослых']/following-sibling::ul//a[text()='Java']"));
        actions.moveToElement(java, 0, 40).click().build().perform();*/

        //click(), позволяет кликать по элементу, либо по месту где находится курсор
        WebElement java = driver.findElement(By.xpath
                ("//a[text()='Для взрослых']/following-sibling::ul//a[text()='Java']"));
        actions.moveToElement(java).click().build().perform();
        actions.click(element).moveToElement(java).click().build().perform();

    }
}