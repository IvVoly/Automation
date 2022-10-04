package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.SingletonDriverClass;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class AppTestTwo {
    @DataProvider(name = "data")
    public Object[][] data() {
        Random rand = new Random();
        return new Object[][]{{rand.nextInt(20)}};
    }

    @DataProvider(name = "dataTwo")
    public Object[][] dataTwo() {
        return new Object[][]{
                {"user", "login"},
                {"admin", "admin"},
                {"user3", "login3"},
        };
    }

    //3.Open any desirable site and verify title

    @Test
    public void verifyTitle() {
        String expectedTitle = "UKR.NET: Всі новини України, останні новини дня в Україні та Світі";
        WebDriver driver = SingletonDriverClass.getInstanceOfSingletonDriverClass().getDriver();
        driver.get("https://www.ukr.net");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Test failed! Wrong Title!");
        driver.close();
    }

    //3.Using Random java class Random rand = new Random(); Validate that random returns values in the correct range
    // ( for example use range 10)

    @Test(dataProvider = "data")
    public void validateValue(int number) {
        System.out.println(number);
        assertTrue(number >= 0 && number <= 10, "Wrong! value must be in range from 0 to 10" + number);
    }

    //3.Create test with a usage of DataProvider, use at least 3 sets of data

    @Test(dataProvider = "dataTwo")
    public void verifyLoginAndPass(String user, String password) {
        String actualUser = "Yankee";
        String actualPassword = "Loreen";
        SoftAssert soft = new SoftAssert();
        soft.assertNotEquals(actualUser, user);
        soft.assertNotEquals(actualPassword, password);
        soft.assertAll();
    }

}
