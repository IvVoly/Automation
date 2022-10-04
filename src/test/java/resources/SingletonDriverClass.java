package resources;

//1.Implement singleton pattern for Webdriver

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriverClass {

    private static SingletonDriverClass instanceOfSingletonDriverClass;

    private WebDriver driver;

    private SingletonDriverClass(){
        driver = new ChromeDriver();
    }

    public static SingletonDriverClass getInstanceOfSingletonDriverClass(){
        if(instanceOfSingletonDriverClass == null){
            instanceOfSingletonDriverClass = new SingletonDriverClass();
        }
        return instanceOfSingletonDriverClass;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
