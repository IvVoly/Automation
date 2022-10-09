package Task3;

/*Create 3 Java Classes with String variables which will contain css and xpath locators for each field, including
        buttons. Implement those classes for Login, Registration and Profile page, (Try not to use ids):*/

public class LoginPage {
    String loginUrl = "https://butlers.ua/ua/login?returnUrl=%2Fua%2F";
    String regButtonXpath = "//div[contains(@class,'login-page')]//input[@type=\"button\"][@value=\"Зареєструватися\"]";
    String regButtonCss = "div[class*=\"login-page\"] input[type=\"button\"][value=\"Зареєструватися\"]";
    String emailFieldXpath = "//div[contains(@class,'login-page')]//input[@class=\"email\"]";
    String emailFieldCss = "div[class*=\"login-page\"] #Email";
    String passFieldXpath = "//div[contains(@class,'login-page')]//input[@class=\"password\"]";
    String passFieldCss = "div[class*=\"login-page\"] #Password";
    String chkRememberMeXpath = "//div[contains(@class,'login-page')]//input[@type=\"checkbox\"]";
    String chkRememberMeCss = "div[class*=\"login-page\"] #RememberMe";
    String passRecoveryXpath = "//div[contains(@class,'login-page')]//a[contains(@href,'passwordrec')]";
    String passRecoveryCss = "div[class*=\"login-page\"] a[href*='passwordrec']";
    String linkLoginXpath = "//div[@class='header-links']//a[contains(text(),'Вхід')]"; //Not good idea to use index in xpath. Try to build another locator (with text).
    String linkLoginCss = "div.header-links a[href*='login']";
}
