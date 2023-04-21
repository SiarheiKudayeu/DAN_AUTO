package testng.parallel;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Ex2 {
    WebDriver driver;
    @BeforeClass
    public void start(){
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
    }
    @AfterClass
    public void close(){
       driver.quit();
    }
    @Test(groups = {"smoke"})
    public void checkWebPageTitle(){
        driver.get("https://klopotenko.com/");
        assertTrue(driver.getTitle().equals("Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка"),"Названия страниц не совпадают," +
                " я ожидал другого");
        assertFalse(driver.getTitle().equals("Євген Клоп4отенко - Кулінарні рецепти від Євгена Клопотенка"),"Названия страниц не совпадают," +
                " я ожидал другого");
        assertEquals(driver.getTitle(),"Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка","Названия страниц не совпадают");
        assertNotEquals(driver.getTitle(),"Євген Клопот4енко - Кулінарні рецепти від Євгена Клопотенка","Названия страниц не совпадают");
    }


    @Test(groups = {"smoke","regression"})
    public void checkofCheckBox(){

        driver.get("https://klopotenko.com/login/");
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
        assertFalse(checkbox.isSelected(), "Чекбокс уже нажат");
    }


    @Test(groups = {"regression"})
    public void countOfIngredients(){

        driver.get("https://klopotenko.com/solodko-yaskravo-aromatno-zapechena-morkva-z-rozmarynom-i-mandarynovym-sokom-vid-yevgena-klopotenka/");
        new Waiters(driver).waitForPresenceOfElementLocated(By.xpath("//div[@class='col-12 col-md-6']/div/div"));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div"));
        assertTrue(elements.size()==5,"Количество ингридиентов не равно 5, оно равно "
                +elements.size());
    }
}
