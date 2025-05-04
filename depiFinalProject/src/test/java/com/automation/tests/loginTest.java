package com.automation.tests;
import com.automation.base.BaseTest;
import com.automation.pages.loginPage;
import com.automation.pages.inventoryPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import com.automation.dataProviders.users;

import java.time.Duration;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class loginTest  extends BaseTest {
    public loginPage loginPage;
    public inventoryPage inventoryPage;

    @Test(dataProvider = "getLoginCredentials", dataProviderClass = users.class, description = "Check Login For all  accepted Users", groups = "login")
    public void testLogin(String username, String password) {
        loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/v1/index.html");

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPage.productTitleLocator));

        Assert.assertTrue(inventoryPage.getProductTitle().isDisplayed(), "Login failed or product title not visible.");
    }

}



























