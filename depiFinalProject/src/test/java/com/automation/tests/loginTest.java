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

public class loginTest  extends BaseTest {
    public loginPage loginPage;
    public inventoryPage inventoryPage;



    @Test(dataProvider = "getLoginCredentials", dataProviderClass = users.class, description = "Check Login For all  accepted Users", groups = "login")
    public void testLogin(String username, String password) {

        loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/v1/index.html");



//        // Wait until the username field is visible and perform login
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();
        try {
            Thread.sleep(3000);  // replace with WebDriverWait if needed
            Alert alert = driver.switchTo().alert();
            alert.dismiss();  // or alert.accept()
        } catch (NoAlertPresentException | InterruptedException e) {
            System.out.println("No alert found.");
        }


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPage.productTitleLocator));

        Assert.assertTrue(inventoryPage.getProductTitle().isDisplayed(), "Login failed or product title not visible.");


        // Wait until the login field is present before proceeding
        WebDriverWait timewait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }


}



























