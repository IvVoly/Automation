package resources;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderClass {

    @DataProvider(name = "EmailFieldNegativeData")
    public static Object[][] dataEmailFieldValid() {
        return new Object[][]{
                {"    "}, {"12323213"}, {"%*&%*"}, {"test.com.ua"}, {"@test.com.ua"}, {"test@"},
                {"te st@com.ua"}, {"test@com.ua."}, {"test@.com.ua"}, {"test@com.  ua"}
        };
    }

    @DataProvider(name = "login")
    public static Object[][] dataForLogin(Method m) {
        if (m.getName().equalsIgnoreCase("verifyUserIsAbleToSuccessfullyLoginWithCorrectData")) {
            return new Object[][]{
                    {"maaloks91@gmail.com", "password"}
            };
        } else {
            return new Object[][]{
                    {"test@test.ua", "qwerty"},
                    {"admin@com.ua", "admin"}

            };
        }
    }
}
