package testng.second;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    static WebDriver driver;
    public void initialDriver(){
        driver = new ChromeDriver();
    }
    public void setDriver(){
        driver.manage().window().maximize();
    }
    public void closeDriver(){
        driver.quit();
    }
    @BeforeClass
    public void startTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        initialDriver();
        setDriver();
    }
    @AfterClass
    public void stopTests(){
        closeDriver();
    }

}
