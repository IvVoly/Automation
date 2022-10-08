package org.example.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import resources.DataProviderClass;
import resources.SingletonDriverClass;

import java.util.*;

/*
        1 - create 3 negative tests in registration form*/

public class AppTest4 {

    String loginPath = "//div[@class='header-links'] //a[contains(@href, 'login')]";
    String registerButPath = "//div[contains(@class, 'login-page')] //input[contains(@class,'register')]";
    String submitRegButPath = "//div[contains(@class, 'registration')]//input[@type='submit']";
    String fieldRegEmailPath = "//div[contains(@class, 'registration')]//input[@name='Email']";

    String sumValidErrPath = "//div[contains(@class, 'registration')]//li";

    String fieldRegFNamePath = "//div[contains(@class, 'registration')]//input[@name='FirstName']";
    String fieldRegLNamePath = "//div[contains(@class, 'registration')]//input[@name='LastName']";
    String fieldRegPhonePath = "//div[contains(@class, 'registration')]//input[@name='Phone']";
    String fieldRegPassPath = "//div[contains(@class, 'registration')]//input[@name='Password']";
    String fieldRegConfirmPassPath = "//div[contains(@class, 'registration')]//input[starts-with(@name,'ConfirmPass')]";
    String validErrEmailXpath = "//div[contains(@class, 'registration')]//span[@id='Email-error']";


    List<String> resultErrorMsgEmail = Arrays.asList(
            "Невірне повідомлення електронної пошти",
            "Електронна пошта обов'язкова."
    );

    Set<String> expectedValidErrorMsg = new HashSet<>(Arrays.asList("Ім'я обов'язкове.", "Прізвище обов'язкове.",
            "Електронна пошта обов'язкова.", "телефон обов'язковий", "Password is required.", "Пароль обов'язковий."));

    private WebDriver driver;

    @BeforeSuite()
    public void setup() {
        this.driver = SingletonDriverClass.getInstanceOfSingletonDriverClass().getDriver();
    }

    @BeforeTest()


    @BeforeClass()
    public void actions() {
        driver.get("https://butlers.ua/ua/");
        WebElement login = driver.findElement(By.xpath(loginPath));
        login.click();
        WebElement register = driver.findElement(By.xpath(registerButPath));
        register.click();
    }


    @Test(priority = 2, dataProvider = "EmailFieldNegativeData", dataProviderClass = DataProviderClass.class)
    public void fieldEmailValidNegativeTest(String incorrect) {
        SoftAssert soft = new SoftAssert();
        WebElement fieldEmail = driver.findElement(By.xpath(fieldRegEmailPath));
        fieldEmail.clear();
        fieldEmail.sendKeys(incorrect + Keys.RETURN);
        WebElement validErrMsgEmail = driver.findElement(By.xpath(validErrEmailXpath));
        soft.assertTrue(resultErrorMsgEmail.contains(validErrMsgEmail.getText()));
        soft.assertAll();
    }

    @Test(priority = 3)
    public void fieldEmailValidNegativeSecondTest() {
        SoftAssert soft = new SoftAssert();
        WebElement fieldName = driver.findElement(By.xpath(fieldRegFNamePath));
        WebElement fieldLastName = driver.findElement(By.xpath(fieldRegLNamePath));
        WebElement fieldEmail = driver.findElement(By.xpath(fieldRegEmailPath));
        WebElement fieldPhone = driver.findElement(By.xpath(fieldRegPhonePath));
        WebElement fieldPassword = driver.findElement(By.xpath(fieldRegPassPath));
        WebElement fieldConfirmPassword = driver.findElement(By.xpath(fieldRegConfirmPassPath));
        fieldName.clear();
        fieldName.sendKeys("abc");
        fieldLastName.clear();
        fieldLastName.sendKeys("abc");
        fieldEmail.clear();
        fieldEmail.sendKeys("test@test");
        fieldPhone.clear();
        fieldPhone.sendKeys("1234567");
        fieldPassword.clear();
        fieldPassword.sendKeys("abcabc");
        fieldConfirmPassword.clear();
        fieldConfirmPassword.sendKeys("abcabc");
        WebElement submitRegisterButton = driver.findElement(By.xpath(submitRegButPath));
        submitRegisterButton.click();
        WebElement sumValidErrMsg = driver.findElement(By.xpath(sumValidErrPath));
        soft.assertTrue(resultErrorMsgEmail.contains(sumValidErrMsg.getText()));
        driver.navigate().refresh();
        soft.assertAll();
    }

    @Test(priority = 1)
    public void fieldsEmptyValidTest() {
        SoftAssert soft = new SoftAssert();
        List<WebElement> errorMessages;
        WebElement submitRegisterButton = driver.findElement(By.xpath(submitRegButPath));
        submitRegisterButton.click();
        errorMessages = driver.findElements(By.className("field-validation-error"));
        for (WebElement element : errorMessages) {
            soft.assertTrue(expectedValidErrorMsg.contains(element.getText()));
            System.out.println(element.getText());
        }
        soft.assertAll();
    }

    @AfterClass()
    public void endOperations() {
        driver.close();
    }
}
