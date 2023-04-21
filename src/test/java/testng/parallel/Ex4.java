package testng.parallel;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Ex4 {
    private static class Labesl{
        private static final String ukLocalisation = "UA";
        private static final String enLocalisation = "EN";
        private static final String ruLocalisation = "RU";

    }
    @Test(groups = {"smoke"})
    public void checkWebPageTitle(){
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        assertTrue(driver.getTitle().equals("Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка"),"Названия страниц не совпадают," +
                " я ожидал другого");
        assertFalse(driver.getTitle().equals("Євген Клоп4отенко - Кулінарні рецепти від Євгена Клопотенка"),"Названия страниц не совпадают," +
                " я ожидал другого");
        assertEquals(driver.getTitle(),"Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка","Названия страниц не совпадают");
        assertNotEquals(driver.getTitle(),"Євген Клопот4енко - Кулінарні рецепти від Євгена Клопотенка","Названия страниц не совпадают");
        driver.quit();
    }


    @Test(groups = {"smoke"})
    public void checkofCheckBox(){
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/login/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        WebElement checkbox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']")));
        assertFalse(checkbox.isSelected(),"Чекбокс уже нажат");
        checkbox.click();
        WebElement newCheckBox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        assertFalse(newCheckBox.isSelected(),"Чекбокс уже нажат");
        checkbox.click();
        //assertTrue(checkbox.isSelected(), "Чекбокс уже нажат");
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
        driver.quit();
    }


    @Test(groups = {"regression"})
    public void countOfIngredients(){
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/solodko-yaskravo-aromatno-zapechena-morkva-z-rozmarynom-i-mandarynovym-sokom-vid-yevgena-klopotenka/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div"));
        assertTrue(elements.size()==5,"Количество ингридиентов не равно 5, оно равно "
                +elements.size());
        driver.quit();
    }
    @Test
    public void checkForLocalisation(){
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        assertTrue(driver.findElement(By.xpath("//span[text()='UA']/.."))
                .isEnabled());
        assertTrue(driver.findElement(By.xpath("//span[text()='EN']/.."))
                .isEnabled());
        assertTrue(driver.findElement(By.xpath("//span[text()='RU']/.."))
                .isEnabled());
        driver.findElement(By.xpath("//span[text()='EN']/..")).click();
        new Waiters(driver).waitForPresenceOfElementLocated(By.xpath("//li[@id='menu-item-5047925']//a[text()='Online-store']"));
        ArrayList<WebElement> localisation = (ArrayList<WebElement>) driver.findElements(By.cssSelector(".wpml-ls-statics-shortcode_actions span"));
        ArrayList<String> textOfLocal = new ArrayList<>(Arrays.asList(Labesl.ukLocalisation,
                Labesl.ruLocalisation, Labesl.enLocalisation));
        for (int i=0; i< localisation.size(); i++){
            assertEquals(localisation.get(i).getText(),textOfLocal.get(i),"Элементы не совпадают");
        }
        driver.quit();
    }
    @Test(dataProvider = "searchWords")
    public void searchFuncuanality(String inputWord, String resultWord){
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        driver.findElement(By.xpath("//span[text()='Пошук']")).click();
        WebElement search = new Waiters(driver).waitForPresenceOfElementLocated(By.xpath("//input[@placeholder='Пошук...']"));
        search.sendKeys(inputWord);
        search.submit();
        new Waiters(driver).waitForTitleContains("Ви шукали");
        WebElement resultSearch = new Waiters(driver).waitForPresenceOfElementLocated(By.tagName("h2"));
        assertTrue(resultSearch.getText().contains(resultWord),"полученный текст '"+resultSearch.getText()
                +"'. Ожтдаемый в нем текст 'Пряник'");
        driver.quit();
    }
    @DataProvider(name = "searchWords")
    public Object[][] createData() {
        return new Object[][]{
                {"Пряник","ПРЯНИК"},
                {"Манник","МАННИК"},
                {"Омлет","ОМЛЕТ"}
        };
    }
}
