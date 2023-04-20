package org.framestep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.waiters.WaitersStart;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class Ex1{

    private static class Labels{
        private static final String pisniiStil = "ПІСНИЙ СТІЛ";
        private static final String straviNaVelikDen = "СТРАВИ НА ВЕЛИКДЕНЬ";
        private static final String ukrainkaKuchnia = "УКРАЇНСЬКА КУХНЯ";
        private static final String recepty = "РЕЦЕПТИ";
        private static final String forFalseAsserts = "Просто слова";
    }
    @Test
    public void checkHeaderTitle() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WaitersStart wait = new WaitersStart(driver);
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        wait.waitForPresentElementLocated(By.xpath("//a[@aria-label= 'dismiss cookie message']"));
        driver.findElement(By.xpath("//a[@aria-label= 'dismiss cookie message']")).click();
        ArrayList<WebElement> headerTitles = wait.waitForPresentElementsLocatedAndReturnArrayList(By.xpath("//ul[@id='menu-main_menu_our-ua']/li/a"));
        System.out.println(headerTitles.size());
        //сравнивает между собой два объекта, или два значения.
        assertEquals(headerTitles.get(0).getText(), Labels.pisniiStil);
        System.out.println(headerTitles.get(1).getText());
        System.out.println((headerTitles.get(1).getText()).equals(Labels.straviNaVelikDen));
        System.out.println(headerTitles.get(2).getText());
        System.out.println(headerTitles.get(3).getText());
        //assertTrue() - тест считается пройденым если в параметры метода передано true
        assertTrue((headerTitles.get(1).getText()).equals(Labels.straviNaVelikDen));
        //assertFalse() - тест считается пройденым если в параметры метода передано false
        assertFalse((headerTitles.get(2).getText()).equals(Labels.forFalseAsserts));
        //assertNotEquals() - тест считается пройденным, если переданные в качестве параметров
        //методы не идентичны.
        assertNotEquals(headerTitles.get(0).getText(), Labels.forFalseAsserts);
        driver.close();
    }


}
