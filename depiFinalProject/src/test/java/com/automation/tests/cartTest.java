package com.automation.tests;
import com.automation.base.BaseTest;
import com.automation.pages.loginPage;
import com.automation.pages.inventoryPage;
import com.automation.pages.cartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import com.automation.dataProviders.users;

import java.time.Duration;

import org.openqa.selenium.By;
public class cartTest  extends BaseTest {
//    private WebDriver driver;
    private loginPage loginPage;
    private inventoryPage inventoryPage;
    private cartPage cartPage;



//    @Test(dependsOnGroups = {"login"}, description = "Verify all products can be added to cart and cart icon updates correctly")
    @Test
    public void testAddAllProductsToCart() {

//        loginPage = new loginPage(driver);
//        loginPage.enterUserName("standard_user");
//        loginPage.enterPassword("secret_sauce");
//        inventoryPage = loginPage.clickLoginButton();
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        inventoryPage = new inventoryPage(driver);
        cartPage = new cartPage(driver);

        inventoryPage.addAllProductsToCart();
        int expectedCount = inventoryPage.getCountOfProductsInCart();
        int actualCount = cartPage.getCartItemCount();

        Assert.assertEquals(actualCount, expectedCount, "Cart count should match added product count.");
    }
}
