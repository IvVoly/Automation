package Task3;

/*Create 3 Java Classes with String variables which will contain css and xpath locators for each field, including
        buttons. Implement those classes for Login, Registration and Profile page, (Try not to use ids):*/


public class ProfilePage {
    String linkAccountXpath = "(//a)[2]";
    String linkAccountCss = "div.header-links a[href*='customer']";
    String butNavInfoAcXpath = "//div[contains(@class,'account-navigation')]//a[contains(@href,'info')]";
    String butNavInfoAcCss = "div [class*='account-navigation'] a[href*='info']";
    String butNavAddressesAcXpath = "//div[contains(@class,'account-navigation')]//a[contains(@href,'addresses')]";
    String butNavAddressesAcCss = "div [class*='account-navigation'] a[href*='addresses']";
    String butNavOrdersAcXpath = "//div[contains(@class,'account-navigation')]//a[contains(@href,'order')]";
    String butNavOrdersAcCss = "div [class*='account-navigation'] a[href*='order']";
    String butNavStockAcXpath = "//div[contains(@class,'account-navigation')]//a[contains(@href,'stock')]";
    String butNavStockAcCss = "div [class*='account-navigation'] a[href*='stock']";
    String butNavChangePassAcXpath = "//div[contains(@class,'account-navigation')]//a[contains(@href,'changepass')]";
    String butNavChangePassAcCss = "div [class*='account-navigation'] a[href*='changepass']";
    String butNavReviewsAcXpath = "//div[contains(@class,'account-navigation')]//a[contains(@href,'reviews')]";
    String butNavReviewsAcCss = "div [class*='account-navigation'] a[href*='reviews']";
    String butNavLogOutAcXpath = "//div[contains(@class,'account-navigation')]//a[contains(@href,'logout')]";
    String butNavLogOutAcCss = "div [class*='account-navigation'] a[href*='logout']";
    String radioMGenderXpath = "//div[contains(@class, 'account-page')]//input[@type='radio' and @value='M']";
    String radioMGenderCss = "div [class*='account-page'] input[type=radio][value='M']";
    String radioFGenderXpath = "//div[contains(@class, 'account-page')]//input[@type='radio' and @value='F']";
    String radioFGenderCss = "div [class*='account-page'] input[type=radio][value='F']";
    String fieldFNameXpath = "//div[contains(@class, 'account-page')]//input[@name='FirstName']";
    String fieldLNameXpath = "//div[contains(@class, 'account-page')]//input[@name='LastName']";
    String fieldFNameCss = "div [class*='account-page'] #FirstName";
    String fieldLNameCss = "div [class*='account-page'] #LastName";
    String optionDateOfBirthXpath = "//div[contains(@class, 'account-page')] //select[contains(@name,'Day')]";
    String optionDateOfBirthCss = "div [class*='account-page'] select[name*='Day']";
    String optionMonthOfBirthXpath = "//div[contains(@class, 'account-page')] //select[contains(@name,'Month')]";
    String optionMonthOfBirthCss = "div [class*='account-page'] select[name*='Month']";
    String optionYearOfBirthXpath = "//div[contains(@class, 'account-page')] //select[contains(@name,'Year')]";
    String optionYearOfBirthCss = "div [class*='account-page'] select[name*='Year']";
    String fieldEmailXpath = "//div[contains(@class, 'account-page')]//input[@name='Email']";
    String fieldEmailCss = "div [class*='account-page'] #Email";
    String fieldPhoneXpath = "//div[contains(@class, 'account-page')]//input[@name='Phone']";
    String fieldPhoneCss = "div [class*='account-page'] #Phone";
    String chkNewsXpath = "//div[contains(@class,'account-page')]//input[@type='checkbox' and starts-with(@name,'News')]";
    String chkNewsCss = "div [class*='account-page'] input[type=checkbox][id^='News']";
    String LinkloginXpath = "//div[contains(@class, 'account-page')]//a[last()]";
    String LinkLoginCss = "div [class*='account-page'] a:last-of-type";
    String buttonSaveXpath = "//div[contains(@class, 'account-page')]//input[starts-with(@name,'save-info')]";
    String buttonSaveCss = "div [class*='account-page'] input[id^='save-info']";
}
