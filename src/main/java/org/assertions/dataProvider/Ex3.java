package org.assertions.dataProvider;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Ex3  extends BaseTest {
    private static class Locators {
        private final static By loginField = By.xpath("//input[@id='username-5035946']");
        private final static By passwordField = By.xpath("//input[@id='user_password-5035946']");
        private final static By checkBoxDisabled = By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']");
        private final static By checkBoxEnabled = By.xpath("//i[@class='um-icon-android-checkbox-outline']");

        private final static By logInButton = By.xpath("//input[@type='submit']");
        private final static By registrationButton = By.xpath("//a[@class='um-button um-alt']");
        private final static By forgotPassButton = By.xpath("//a[@class='um-link-alt']");
        private final static By alertName = By.xpath("//p[@class='um-notice err um-error-code-invalid_username']");
        private final static By alertPassword = By.xpath("//div[@class='um-field-error']");
        private final static By popUpcross = By.xpath("//a[@id='catfish-close']");
        private final static By facebookButton = By.xpath("//i[@class='um-faicon-facebook-square']");
        private final static By searchButton = By.xpath("//span[text()='Пошук']");
        private final static By inputSearch = By.xpath("//input[@placeholder='Пошук...'][1]");
        private final static By submitButton = By.xpath("//button[@type='submit'][1]");
        private final static By titleSearchText = By.xpath("//div[@class='sec-title-holder']/h2");
        private final static By noResultButton = By.xpath("//div[@class='gs-snippet']");






    }
    private void closePopUp(){
        wait.waitForPresentElementLocated(Locators.popUpcross);
        driver.findElement(Locators.popUpcross).click();
    }
    private static class Labels {
        private static final String pisniiStil = "ПІСНИЙ СТІЛ";
        private static final String straviNaVelikDen = "СТРАВИ НА ВЕЛИКДЕНЬ";
        private static final String ukrainkaKuchnia = "УКРАЇНСЬКА КУХНЯ";
        private static final String recepty = "РЕЦЕПТИ";
        private static final String forFalseAsserts = "Просто слова";
        private static final String errorNameMessage = "Error: The username %s is not registered " +
                "on this site. If you are unsure of your username, try your email address instead.";
        private static final String errorPassMessage = "Пароль невірний. Спробуйте ще раз";
        private static final String searchMessage = "ЗНАЙДЕНО ЗА ЗАПИТОМ: %s";
    }

    @BeforeClass
    public void acceptCookies() {
        driver.get("https://klopotenko.com/login/");
        wait.waitForPresentElementLocated(By.xpath("//a[@aria-label= 'dismiss cookie message']"));
        driver.findElement(By.xpath("//a[@aria-label= 'dismiss cookie message']")).click();
    }

    @Test(dataProvider = "firstDataProvider")
    public void checkSearchResultsField(String word) {
        String searcWord = word;
        driver.get("https://klopotenko.com/");
        wait.waitForPresentElementLocated(Locators.searchButton);
        driver.findElement(Locators.searchButton).click();
        wait.waitForPresentElementLocated(Locators.inputSearch);
        driver.findElement(Locators.inputSearch).sendKeys(searcWord);
        driver.findElement(Locators.submitButton).click();
        wait.waitForPresentElementLocated(Locators.titleSearchText);
        String resultText = String.format(Labels.searchMessage,searcWord).toUpperCase();
        assertEquals(driver.findElement(Locators.titleSearchText).getText(),
                resultText);
    }


    @DataProvider(name = "firstDataProvider")
    public Object[] createData(){
        return new Object[]{"Картошка","Тушенка","Мандарин"};
    }
}
