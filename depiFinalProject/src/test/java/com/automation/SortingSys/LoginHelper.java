package com.automation.SortingSys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper {
    
        public static void performLogin(WebDriver driver) {
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
