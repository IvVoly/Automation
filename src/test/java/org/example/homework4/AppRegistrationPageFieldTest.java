package org.example.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import resources.DataProviderClass;
import resources.SingletonDriverClass;

import java.util.*;

/*
        1 - create 3 negative tests in registration form*/

public class AppRegistrationPageFieldTest {  /*Name of class should be understandable. Rename it, please.*/

    String loginPath = "//div[@class='header-links']//a[contains(@href,'login')]";
    String registerButPath = "//div[contains(@class,'login-page')]//input[contains(@class,'register')]";
    String submitRegButPath = "//div[contains(@class,'registration')]//input[@type='submit']";
    String fieldRegEmailPath = "//div[contains(@class,'registration')]//input[@name='Email']";

    String sumValidErrPath = "//div[contains(@class,'registration')]//li";

    String fieldRegFNamePath = "//div[contains(@class,'registration')]//input[@name='FirstName']";
    String fieldRegLNamePath = "//div[contains(@class,'registration')]//input[@name='LastName']";
    String fieldRegPhonePath = "//div[contains(@class,'registration')]//input[@name='Phone']";
    String fieldRegPassPath = "//div[contains(@class,'registration')]//input[@name='Password']";
    String fieldRegConfirmPassPath = "//div[contains(@class,'registration')]//input[starts-with(@name,'ConfirmPass')]";
    String validErrEmailXpath = "//div[contains(@class,'registration')]//span[@id='Email-error']";


    List<String> resultErrorMsgEmail = Arrays.asList(
            "Невірне повідомлення електронної пошти",
            "Електронна пошта обов'язкова."
    );

    Set<String> expectedValidErrorMsg = new HashSet<>(Arrays.asList("Ім'я обов'язкове.", "Прізвище обов'язкове.",
            "Електронна пошта обов'язкова.", "телефон обов'язковий", "Password is required.", "Пароль обов'язковий."));

    private WebDriver driver;
    private SoftAssert soft;

    @BeforeSuite()
    public void setup() {
        this.driver = SingletonDriverClass.getInstanceOfSingletonDriverClass().getDriver();
        soft = new SoftAssert();
    }

    @BeforeTest()

    @BeforeClass()
    public void preconditions() {
        driver.get("https://butlers.ua/ua/");
        WebElement loginLink = driver.findElement(By.xpath(loginPath));
        loginLink.click();  /*Login what? Button, link, label, field? Same for register.*/
        WebElement registerButton = driver.findElement(By.xpath(registerButPath));
        registerButton.click();
    }


    @Test(priority = 2, dataProvider = "EmailFieldNegativeData", dataProviderClass = DataProviderClass.class)
    public void verifyEmailFieldValidation(String incorrect) { /*Test's method should be understandable.*/
        WebElement emailField = driver.findElement(By.xpath(fieldRegEmailPath)); /*Variable should look like - name + type of element*/
        emailField.clear();
        emailField.sendKeys(incorrect + Keys.RETURN);
        WebElement validErrMsgEmail = driver.findElement(By.xpath(validErrEmailXpath));
        Assert.assertTrue(resultErrorMsgEmail.contains(validErrMsgEmail.getText()), "should be shown error message about wrong format of email");
    }  /*If you have only one assertion - use hard assert (Assert).*/

    @Test(priority = 3)
    public void verifySystemShowsErrorWhenUserEnterWrongEmail() {
        WebElement nameField = driver.findElement(By.xpath(fieldRegFNamePath));
        WebElement lastNameField = driver.findElement(By.xpath(fieldRegLNamePath));
        WebElement emailField = driver.findElement(By.xpath(fieldRegEmailPath));
        WebElement phoneField = driver.findElement(By.xpath(fieldRegPhonePath));
        WebElement passwordField = driver.findElement(By.xpath(fieldRegPassPath));
        WebElement confirmPasswordField = driver.findElement(By.xpath(fieldRegConfirmPassPath));
        nameField.clear();
        nameField.sendKeys("abc");
        lastNameField.clear();
        lastNameField.sendKeys("abc");
        emailField.clear();
        emailField.sendKeys("test@test");
        phoneField.clear();
        phoneField.sendKeys("1234567");
        passwordField.clear();
        passwordField.sendKeys("abcabc");
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys("abcabc");
        WebElement submitRegisterButton = driver.findElement(By.xpath(submitRegButPath));
        submitRegisterButton.click();
        WebElement sumValidErrMsg = driver.findElement(By.xpath(sumValidErrPath));
        soft.assertTrue(resultErrorMsgEmail.contains(sumValidErrMsg.getText()), "should be shown error message about wrong format of email");
        /*Add assert message.*/
        soft.assertAll();
    }

    @Test(priority = 1)
    public void verifySystemShowsFieldValidationErrorsIfFillInNoData() {  /*Test's method should be understandable.*/
        List<WebElement> errorMessages;
        WebElement submitRegisterButton = driver.findElement(By.xpath(submitRegButPath));
        submitRegisterButton.click();
        errorMessages = driver.findElements(By.className("field-validation-error"));
        for (WebElement element : errorMessages) { /*Add assert message.*/
            soft.assertTrue(expectedValidErrorMsg.contains(element.getText()), "must be shown error message about field are required");
            System.out.println(element.getText());
        }
        soft.assertAll();
    }

    @AfterMethod() /*Create @AfterMethod*/
    public void endOperationsMethod() {
        driver.navigate().refresh();
    }

    @AfterClass()
    public void endOperations() {
        driver.close();
    }
}
