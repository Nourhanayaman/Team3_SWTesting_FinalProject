//package com.automation.tests;
//
//import com.automation.base.BaseTest;
//import com.automation.pages.inventoryPage;
//import com.automation.pages.loginPage;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import com.automation.dataProviders.loginDataProvider;
//import java.io.IOException;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;
//import java.lang.Thread;
//
//
//public class loginTests extends BaseTest {
//
//
//    loginPage login;
//    inventoryPage inventory;
//
//
//
//
////   @Test(dataProvider = "loginCredentials", dataProviderClass = loginDataProvider.class)
////String username, String password
//   public void loginTest() {
//
//       login.enterUserName("standard_user");
//
//       login.enterPassword("secret_sauce");
//
//       inventory = login.clickLoginButton();
//
//       // Handle alert if present
//       try {
//           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//           wait.until(ExpectedConditions.alertIsPresent());
//           driver.switchTo().alert().dismiss();
//       } catch (org.openqa.selenium.NoAlertPresentException | org.openqa.selenium.TimeoutException e) {
//           // No alert appeared — continue normally
//       }
//
//
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//       wait.until(ExpectedConditions.visibilityOf(inventory.getProductTitle()));
//       driver.switchTo().alert().dismiss();
//       Assert.assertTrue(inventory.getFooter().isDisplayed());
////       Thread.sleep(2000);
////       TakesScreenshot screenshot = (TakesScreenshot) driver;
////       Thread.sleep(2000);
////       byte[] screenShotByte = screenshot.getScreenshotAs(OutputType.BYTES);
////
//
//   }
//
//
//}


package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.loginPage;
import com.automation.pages.inventoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import com.automation.dataProviders.loginDataProvider;

import java.time.Duration;
import org.openqa.selenium.By;


public class loginTests extends BaseTest {

    private loginPage loginPage;
    private inventoryPage inventoryPage;



   @Test(dataProvider = "loginCredentials", dataProviderClass = loginDataProvider.class)
    public void testLogin(String username, String password) {
        // Initialize the login page
        loginPage = new loginPage(driver);

       // Define WebDriverWait instance
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       // Wait until the username field is visible and perform login
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
       loginPage.enterUserName(username);
       loginPage.enterPassword(password);
       inventoryPage = loginPage.clickLoginButton();



//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPage.productTitleLocator));
//
//       Assert.assertTrue(inventoryPage.getProductTitle().isDisplayed(), "Login failed or product title not visible.");



       inventoryPage.waitForProductTitle();



     //  Assert.assertTrue(inventoryPage.getProductTitle().isDisplayed(), "Login failed or product title not visible.");


    }
}

