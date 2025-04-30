package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set Chrome options to disable password manager and notifications
        ChromeOptions options = new ChromeOptions();

        // Disable password manager and save password prompts
        options.addArguments("--disable-password-manager");
        options.addArguments("--disable-save-password-bubble");

        // Disable notifications
        options.addArguments("--disable-notifications");

        // Disable infobars (like "Chrome is being controlled...")
        options.addArguments("disable-infobars");

        // Optionally run in headless mode
        // options.addArguments("--headless");

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");


        // Wait until the login field is present before proceeding
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
