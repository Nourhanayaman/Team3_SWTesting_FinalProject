package com.automation.base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;


@Listeners(AllureTestNg.class)
public class BaseTest {

    public WebDriver driver;

    public WebDriverWait wait;


    private static final String SCREENSHOT_FOLDER = "./TestsScreenshots/";


    @Attachment(value = "{testName} - Screenshot", type = "image/png")
    public byte[] takeScreenshotAndSave(String testName) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Save to disk
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = SCREENSHOT_FOLDER + testName + "_" + timestamp + ".png";
        File destFile = new File(fileName);

        try {
            Files.createDirectories(destFile.getParentFile().toPath());
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Saved screenshot: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot to " + fileName + ": " + e.getMessage());
        }

        return screenshotBytes;
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @AfterMethod(alwaysRun = true)
    public void attachScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS || result.getStatus() == ITestResult.FAILURE) {
            takeScreenshotAndSave(result.getName());
        }
    }

    @AfterClass
    public void tearDown() {
      if (driver != null) {
           driver.quit();
       }
    }
}
