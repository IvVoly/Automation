package Task3;

/*Create 3 Java Classes with String variables which will contain css and xpath locators for each field, including
        buttons. Implement those classes for Login, Registration and Profile page, (Try not to use ids):*/

public class RegistrationPage {
    String registarionPage = "https://butlers.ua/ua/register?returnUrl=%2Fua%2F";
    String radioMGenderXpath = "//div[contains(@class,'registration')]//input[@type='radio' and @value='M']";
    String radioMGenderCss = "div[class*='registration'] input[type=radio][value='M']";
    String radioFGenderXpath = "//div[contains(@class,'registration')]//input[@type='radio' and @value='F']";
    String radioFGenderCss = "div[class*='registration'] input[type=radio][value='F']";
    String fieldRegFNameXpath = "//div[contains(@class,'registration')]//input[@name='FirstName']";
    String fieldRegLNameXpath = "//div[contains(@class,'registration')]//input[@name='LastName']";
    String fieldRegFNameCss = "div[class*='registration'] #FirstName";
    String fieldRegLNameCss = "div[class*='registration'] #LastName";
    String optionDateOfBirthXpath = "//div[contains(@class,'registration')]//select[contains(@name,'Day')]";
    String optionDateOfBirthCss = "div[class*='registration'] select[name*='Day']";
    String optionMonthOfBirthXpath = "//div[contains(@class,'registration')]//select[contains(@name,'Month')]";
    String optionMonthOfBirthCss = "div[class*='registration'] select[name*='Month']";
    String optionYearOfBirthXpath = "//div[contains(@class,'registration')]//select[contains(@name,'Year')]";
    String optionYearOfBirthCss = "div[class*='registration'] select[name*='Year']";
    String fieldRegEmailXpath = "//div[contains(@class,'registration')]//input[@name='Email']";
    String fieldRegEmailCss = "div[class*='registration'] #Email";
    String fieldRegPhoneXpath = "//div[contains(@class,'registration')]//input[@name='Phone']";
    String fieldRegPhoneCss = "div[class*='registration'] #Phone";
    String chkNewsXpath = "//div[contains(@class,'registration')]//input[@type='checkbox' and starts-with(@name,'News')]";
    String chkNewsCss = "div[class*='registration'] input[type=checkbox][id^='News']";
    String fieldRegPassXpath = "//div[contains(@class,'registration')]//input[@name='Password']";
    String fieldRegPassCss = "div[class*='registration'] #Password";
    String fieldRegConfirmPassXpath = "//div[contains(@class,'registration')]//input[starts-with(@name,'ConfirmPass')]";
    String fieldRegConfirmPassCss = "div[class*='registration'] input[id^='ConfirmPass']";
    String buttonSubmitRegXpath = "//div[contains(@class,'registration')]//input[starts-with(@name,'register-b')]";
    String buttonSubmitRegCss = "div[class*='registration'] input[id^='register-b']";
}
