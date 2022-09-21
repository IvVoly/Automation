package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rozetka.com.ua");
        Thread.sleep(10000);
        driver.close();
    }
}

