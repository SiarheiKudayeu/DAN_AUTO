package org.assertions.parallel;

import org.assertions.priority.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.waiters.WaitersStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Ex2 {
    private static final long IMPLICITLY_WAIT = 20L;
    static WebDriver driver;
    static WaitersStart wait;
    @BeforeClass
    public void acceptCookies() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WaitersStart(driver);
        driver.get("https://klopotenko.com/");
        wait.waitForPresentElementLocated(By.xpath("//a[@aria-label= 'dismiss cookie message']"));
        driver.findElement(By.xpath("//a[@aria-label= 'dismiss cookie message']")).click();
    }
    @AfterClass
    public void stopTest(){
        driver.quit();
    }


    private static class Labels {
        private static final String pisniiStil = "ПІСНИЙ СТІЛ";
        private static final String straviNaVelikDen = "СТРАВИ НА ВЕЛИКДЕНЬ";
        private static final String ukrainkaKuchnia = "УКРАЇНСЬКА КУХНЯ";
        private static final String recepty = "РЕЦЕПТИ";
        private static final String porady = "ПОРАДИ";
        private static final String noviny = "НОВИНИ";
        private static final String shef = "ШЕФ";
        private static final String magazin = "МАГАЗИН";
        private static final String title = "НОВІ РЕЦЕПТИ";
        private static final String pageTitle = "Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка";

    }

    private static class Locators {
        private final static By cookies = By.xpath("//a[@aria-label= 'dismiss cookie message']");
        private final static By uaLocalisation = By.xpath("//span[text()='UA']");
        private final static By enLocalisation = By.xpath("//span[text()='EN']");
        private final static By ruLocalisation = By.xpath("//span[text()='RU']");
    }

    @Test
    public void acheckHeaderTitle() {
        driver.get("https://klopotenko.com/");
        ArrayList<WebElement> headerTitles = wait.waitForPresentElementsLocatedAndReturnArrayList
                (By.xpath("//ul[@id='menu-main_menu_our-ua']/li/a"));
        //System.out.println(headerTitles.size());
        ArrayList<String> labels = new ArrayList<>(Arrays.asList(
                Labels.pisniiStil,
                Labels.straviNaVelikDen,
                Labels.ukrainkaKuchnia,
                Labels.recepty,
                Labels.porady,
                Labels.noviny,
                Labels.shef,
                Labels.magazin
        ));
        for (int i = 0; i < headerTitles.size(); i++) {
            assertEquals(headerTitles.get(i).getText(), labels.get(i));
        }
    }

    @Test
    public void fcheckTitleOfContainerNovyRecept() {
        driver.get("https://klopotenko.com/");
        WebElement title = wait.waitForPresentElementLocatedBy(By.xpath("//h2[@class='rtin-title'][1]"));
        assertEquals(title.getText(), Labels.title);
    }

    @Test
    public void checkPageTitle() {
        driver.get("https://klopotenko.com/");
        assertEquals(driver.getTitle(), Labels.pageTitle);
    }

    @Test
    public void bcheckLocalisationIsVisible() {
        driver.get("https://klopotenko.com/");
        assertTrue(driver.findElement(Locators.uaLocalisation).isDisplayed());
        assertTrue(driver.findElement(Locators.enLocalisation).isDisplayed());
        assertTrue(driver.findElement(Locators.ruLocalisation).isDisplayed());
    }

    @Test
    public void dcheckcountOfHeaderElements() {
        driver.get("https://klopotenko.com/");
        ArrayList<WebElement> headerTitles = wait.waitForPresentElementsLocatedAndReturnArrayList
                (By.xpath("//ul[@id='menu-main_menu_our-ua']/li/a"));
        assertTrue(headerTitles.size() == 8);
        assertFalse(headerTitles.size() == 9);
    }

}
