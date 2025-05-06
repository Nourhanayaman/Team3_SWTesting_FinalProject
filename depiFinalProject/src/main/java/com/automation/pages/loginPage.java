package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class loginPage {

    WebDriver loginDriver;

    //Locators
    public By userNameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login-button");



    //constructor
    public loginPage(WebDriver driver) {
        this.loginDriver = driver;
    }

    //Actions
    public void enterUserName(String userName) {
        loginDriver.findElement(userNameLocator).sendKeys(userName);
    }


    public void enterPassword(String password) {
        loginDriver.findElement(passwordLocator).sendKeys(password);
    }


    public inventoryPage clickLoginButton() {

        loginDriver.findElement(loginButtonLocator).click();

        return new inventoryPage(loginDriver);

    }

    public void dismissChangePasswordPopupIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(5));
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("change-password-modal")));
            WebElement dismissButton = popup.findElement(By.cssSelector(".close-button, .cancel, .dismiss")); // adjust selector
            dismissButton.click();
        } catch (TimeoutException e) {
            // Popup not present, safe to ignore
        }
    }



}
