package org.assertions.priority;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.waiters.WaitersStart;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;
    static WaitersStart wait;
    private static final long IMPLICITLY_WAIT = 20L;
    private static final long EXPLICITLY_WAIT = 10L;
    private static WebDriver initialDriver(){
        return  new ChromeDriver();
    }
    private static void initialDriver2(){
        driver= new ChromeDriver();
    }
    public static WebDriver getDriver(){
        if(driver==null){
            driver=initialDriver();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
    }
    public static void openInputPage(String webpage){
        getDriver().get(webpage);
    }
    public static void setDriver(){

        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait= new WaitersStart(driver);
    }

    @BeforeClass
    public void startTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        initialDriver2();
        setDriver();
    }
    @AfterClass
    public void stopTest(){
        closeDriver();
    }
}
