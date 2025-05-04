//package com.automation.tests;
//import com.automation.base.BaseTest;
//import com.automation.pages.loginPage;
//import com.automation.pages.inventoryPage;
//import com.automation.pages.cartPage;
//import com.automation.tests.loginTest;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.*;
//import com.automation.dataProviders.users;
//
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//public class cartTest  extends BaseTest {
////    private WebDriver driver;
//    private loginPage loginPage;
//    private inventoryPage inventoryPage;
//    private cartPage cartPage;
//
//
//
////dependsOnMethods = "testLogin"
//    @Test(dependsOnGroups = "login")
//    public void testAddAllProductsToCart() {
//
//
////        driver.get("https://www.saucedemo.com/v1/inventory.html");
//        inventoryPage = new inventoryPage(driver);
//        cartPage = new cartPage(driver);
//
//        inventoryPage.addAllProductsToCart();
//        int expectedCount = inventoryPage.getCountOfProductsInCart();
//        int actualCount = cartPage.getCartItemCount();
//
//        Assert.assertEquals(actualCount, expectedCount, "Cart count should match added product count.");
//    }
//}
