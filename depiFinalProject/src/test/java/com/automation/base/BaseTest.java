package com.automation.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;

import static java.awt.SystemColor.window;
import static java.lang.Thread.sleep;
import static org.apache.commons.lang3.function.FailableFunction.function;

public class BaseTest {

    public WebDriver driver;

    public WebDriverWait wait;


    @BeforeClass
    public void setUp() throws InterruptedException {
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");

        try {
            Thread.sleep(3000);  // replace with WebDriverWait if needed
            Alert alert = driver.switchTo().alert();
            alert.dismiss();  // or alert.accept()
        } catch (NoAlertPresentException e) {
            System.out.println("No alert found.");
        }
    }






    @AfterClass
    public void tearDown() {
      if (driver != null) {
           driver.quit();
       }
    }
}
