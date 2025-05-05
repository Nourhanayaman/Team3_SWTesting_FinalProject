package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

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




}
