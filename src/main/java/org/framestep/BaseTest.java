package org.framestep;

import org.actions_separate.Actions;
import org.assertions.Assertions;
import org.elements.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.waiters.WaitersStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    static WebDriver driver;
    static WaitersStart wait;
    static Actions actions;
    static Assertions assertions;
    static Elements elements;
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
        actions = new Actions(driver);
        assertions = new Assertions(driver);
        elements = new Elements(driver);
    }

    @BeforeClass
    public void startTest(){
        logger.info("Starting test");
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        logger.info("Starting Driver");
        initialDriver2();
        logger.info("Driver setUp");
        setDriver();
    }
    @AfterClass
    public void stopTest(){
        logger.info("Closing Driver");
        closeDriver();
    }
}
