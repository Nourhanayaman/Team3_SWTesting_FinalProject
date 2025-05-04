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
import java.util.ArrayList;
import java.util.Arrays;

import static org.bouncycastle.cms.RecipientId.password;
import static org.testng.Assert.assertEquals;

public class loginTest  extends BaseTest {
    public loginPage loginPage;
    public inventoryPage inventoryPage;

    @Test(dataProvider = "getLoginCredentials", dataProviderClass = users.class,  groups = "login")
    public void testLogin(String username, String password) {
        loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/v1/index.html");

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();


        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPage.productTitleLocator));
            WebElement productTitle = inventoryPage.getProductTitle();
            Assert.assertTrue(productTitle.isDisplayed(), "Product title is not displayed after login.");
        } catch (TimeoutException e) {
            Assert.fail("Product title not visible within timeout. Login likely failed.");
        }
    }




    @Test(dataProvider = "defaultUser", dataProviderClass = users.class)
    public void logoutBtnVisabilityTest(String username, String password) {
        loginPage = new loginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();


        WebElement openMenuBtn = driver.findElement(By.cssSelector(".bm-burger-button > button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", openMenuBtn);


        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPage.logoutButtonLocator));

        // Assert that the logout button is visible
        WebElement logoutButton = driver.findElement(inventoryPage.logoutButtonLocator);
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not visible.");


    }

    @Test(dataProvider = "defaultUser", dataProviderClass = users.class)
    public void logoutTest(String username, String password) {
        loginPage = new loginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();


        WebElement openMenuBtn = driver.findElement(By.cssSelector(".bm-burger-button > button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", openMenuBtn);


        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPage.logoutButtonLocator));
        inventoryPage.logOut();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/v1/index.html", "URL does not match the expected value.");



    }

    @Test(dependsOnMethods = "logoutTest")
    public void accessRestrictedTest(){
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("inventory.html")) {
            Assert.fail("Access to inventory page should be restricted after logout.");
        } else {
            Assert.assertTrue(currentUrl.contains("index.html"), "User was correctly redirected after attempting restricted access.");
        }


    }



    @Test(dataProvider = "defaultUser", dataProviderClass = users.class)
    public void sessionTermination(String username, String password) {
        loginPage = new loginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();



        ((JavascriptExecutor) driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.saucedemo.com/v1/index.html");
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();




        WebElement openMenuBtn = driver.findElement(By.cssSelector(".bm-burger-button > button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", openMenuBtn);


        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPage.logoutButtonLocator));
        inventoryPage.logOut();

        driver.switchTo().window(tabs.get(1));

        driver.switchTo().window(tabs.get(0)); // Switch to the first tab
        driver.navigate().refresh(); // Refresh the page

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/v1/index.html", "Session is not terminated");





    }

}



























