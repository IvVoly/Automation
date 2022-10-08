package org.example.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import resources.DataProviderClass;
import resources.SingletonDriverClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*2,3 - create 1 positive test in login form and 1 negative test in login form*/

public class AppLoginTest4 {
    String loginPath = "//div[@class='header-links'] //a[contains(@href, 'login')]";
    String emailFieldPath = "//div[contains(@class, 'login-page')]//input[@class='email']";
    String passFieldPath = "//div[contains(@class, 'login-page')]//input[@class='password']";
    String submitButtonLoginPath = "//div[contains(@class, 'login-page')]//input[@type='submit']";
    String butNavLogOutAcPath = "//div[contains(@class,'account-navigation')]//a[contains(@href,'logout')]";

    String errorValidationMsg = "//div[contains(@class, 'login-page')]//div[contains(@class, 'message-error ')]";
    String expectedErrorMessage = "Вхід не вдалося. Виправте помилки та повторіть спробу.\nНемає облікового запису клієнта";

    Set<String> expectedAccountMsg = new HashSet<>(Arrays.asList("Персональний кабінет", "ПЕРСОНАЛЬНИЙ КАБІНЕТ"));
    private WebDriver driver;

    @BeforeSuite()
    public void setup() {
        this.driver = SingletonDriverClass.getInstanceOfSingletonDriverClass().getDriver();
    }

    @BeforeTest()


    @BeforeClass()
    public void actions() {
        driver.manage().window().maximize();
        driver.get("https://butlers.ua/ua/");
        WebElement login = driver.findElement(By.xpath(loginPath));
        login.click();
    }


    @Test(dataProvider = "login", dataProviderClass = DataProviderClass.class, priority = 1)
    public void loginTest(String email, String password) {
        WebElement fieldEmail = driver.findElement(By.xpath(emailFieldPath));
        WebElement fieldPassword = driver.findElement(By.xpath(passFieldPath));
        WebElement submit = driver.findElement(By.xpath(submitButtonLoginPath));
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
        submit.click();
        WebElement personalAccount = driver.findElement(By.xpath("(//a)[2]"));
        Assert.assertTrue(expectedAccountMsg.contains(personalAccount.getText()),
                "Icon personal account is displayed");
        personalAccount.click();
        WebElement exitAccount = driver.findElement(By.xpath(butNavLogOutAcPath));
        exitAccount.click();
        WebElement login = driver.findElement(By.xpath(loginPath));
        login.click();
    }

    @Test(dataProvider = "login", dataProviderClass = DataProviderClass.class, priority = 2)
    public void loginNegativeTest(String email, String password) {
        WebElement fieldEmail = driver.findElement(By.xpath(emailFieldPath));
        WebElement fieldPassword = driver.findElement(By.xpath(passFieldPath));
        WebElement submit = driver.findElement(By.xpath(submitButtonLoginPath));
        SoftAssert soft = new SoftAssert();
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
        submit.click();
        WebElement actualErrorMsg = driver.findElement(By.xpath(errorValidationMsg));
        soft.assertTrue(actualErrorMsg.isDisplayed());
        soft.assertEquals(actualErrorMsg.getText(), expectedErrorMessage, "Validation Error to login");
        soft.assertAll();
    }

    @AfterClass()
    public void endOperations() {
        driver.close();
    }
}

