package org.framestep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class Ex2 extends BaseTest {
    @BeforeClass
    public void acceptCookies() {
        driver.get("https://klopotenko.com/");
        wait.waitForPresentElementLocated(By.xpath("//a[@aria-label= 'dismiss cookie message']"));
        driver.findElement(By.xpath("//a[@aria-label= 'dismiss cookie message']")).click();
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
        private final static By novRecept = By.xpath("//h2[@class='rtin-title'][1]");
        private final static By listOfElements2 = By.xpath("//ul[@id='menu-main_menu_our-ua']/li/a");



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
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        for (int i = 0; i < headerTitles.size(); i++) {
            assertEquals(headerTitles.get(i).getText(), labels.get(i));
        }
    }

    @Test
    public void fcheckTitleOfContainerNovyRecept() {
        driver.get("https://klopotenko.com/");
        assertions.elementHaveText(Locators.novRecept,Labels.title);

    }

    @Test
    public void checkPageTitle() {
        driver.get("https://klopotenko.com/");
        assertions.asserPagaTitle(Labels.pageTitle);
    }

    @Test
    public void bcheckLocalisationIsVisible() {
        driver.get("https://klopotenko.com/");
        assertions.elementIsDisplayed(Locators.uaLocalisation);
        assertions.elementIsDisplayed(Locators.enLocalisation);
        assertions.elementIsDisplayed(Locators.ruLocalisation);
    }

    @Test
    public void dcheckcountOfHeaderElements() {
        driver.get("https://klopotenko.com/");
        assertions.listSizeIsEqual(elements.findElements(Locators.listOfElements2),8);
    }
}
