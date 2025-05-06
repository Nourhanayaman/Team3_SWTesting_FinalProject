package com.automation.tests;
import com.automation.base.BaseTest;
import com.automation.pages.loginPage;
import com.automation.pages.inventoryPage;
import com.automation.pages.cartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import com.automation.dataProviders.users;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class cartTest  extends BaseTest {

    private loginPage loginPage;
    private inventoryPage inventoryPage;
    private cartPage cartPage;



//The Test should assert true
    @Test(dataProvider = "defaultUser", dataProviderClass = users.class,priority = 1)
    public void testAddAllProductsToCart(String username, String password) {

        loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/v1/index.html");
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();

      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        inventoryPage = new inventoryPage(driver);
        inventoryPage.clickOnaddToCartP1();
        inventoryPage.clickOnaddToCartP2();
        inventoryPage.clickOnaddToCartP3();
        inventoryPage.clickOnaddToCartP4();
        inventoryPage.clickOnaddToCartP5();
        inventoryPage.clickOnaddToCartP6();

        cartPage = new cartPage(driver);

        int expectedCount = 6;
       int actualCount = cartPage.getCartItemCount();

       Assert.assertEquals(actualCount, expectedCount, "Cart count should match added product count.");
    }




// Test should assert true
    @Test(dependsOnMethods ="testAddAllProductsToCart", priority = 2)
    public void testremoveAllProductsFromCart() {


        inventoryPage = new inventoryPage(driver);
        inventoryPage.clickOnaddToCartP1();
        inventoryPage.clickOnaddToCartP2();
        inventoryPage.clickOnaddToCartP3();
        inventoryPage.clickOnaddToCartP4();
        inventoryPage.clickOnaddToCartP5();
        inventoryPage.clickOnaddToCartP6();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        cartPage = new cartPage(driver);

        boolean isCartBadgeInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(cartPage.CartCounter));

        Assert.assertTrue(isCartBadgeInvisible, "Cart badge should disappear after removing all products.");
    }


    // Test should assert fail
    @Test(dataProvider = "defaultUser", dataProviderClass = users.class ,priority = 4)
    public void CartPersistenceTest(String username, String password) {


        loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/v1/index.html");
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();



        inventoryPage = new inventoryPage(driver);
        inventoryPage.clickOnaddToCartP1();
        inventoryPage.clickOnaddToCartP2();
        inventoryPage.clickOnaddToCartP3();

        cartPage = new cartPage(driver);


        int expectedCartCount = cartPage.getCartItemCount();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver2 = new ChromeDriver(options);
         wait= new WebDriverWait(driver2, Duration.ofSeconds(20));
        driver2.get("https://www.saucedemo.com/v1/index.html");

        try {
            loginPage loginPage2 = new loginPage(driver2);
            loginPage2.enterUserName(username);
            loginPage2.enterPassword(password);
            inventoryPage inventoryPage2 = loginPage2.clickLoginButton();

            cartPage cartPage2 = new cartPage(driver2);
            int actualCartCount = cartPage2.getCartItemCount();

            if (actualCartCount == expectedCartCount) {
                Assert.fail("Cart count should not persist across sessions, but it did. Expected: "
                        + expectedCartCount + ", Actual: " + actualCartCount);
            }

        } catch (Exception e) {
            Assert.fail("Cart badge not visible or other error occurred: " + e.getMessage());
        } finally {
            driver2.quit();
        }
    }


// when run alone pass when run in the class with all tests fail
// Test should assert true
    @Test(dataProvider = "defaultUser", dataProviderClass = users.class , priority = 5)
    public void removeBtnOfCartPageTest(String username, String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/v1/index.html");
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();



        inventoryPage = new inventoryPage(driver);
        inventoryPage.clickOnaddToCartP1();
        inventoryPage.clickOnaddToCartP2();
        inventoryPage.clickOnaddToCartP3();

         wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        cartPage = new cartPage(driver);



        cartPage.clickCart();

        cartPage.clickRemoveBtnP1();
        int secondCount = cartPage.getCartItemCount();
         int expectedCount = 2;
        Assert.assertEquals(secondCount, expectedCount, "Cart count should match added product count.");





    }

    // Test should assert true
    @Test(dataProvider = "defaultUser", dataProviderClass = users.class , priority = 3)
    public void CartBtnVisabilityTest(String username, String password) {
        loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/v1/index.html");
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        inventoryPage = loginPage.clickLoginButton();

        cartPage = new cartPage(driver);


        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.CartBtnLocator));
        // Step 3: Assert that the Cart button is visible
        WebElement cartButton = driver.findElement(cartPage.CartBtnLocator);
        Assert.assertTrue(cartButton.isDisplayed(), "Cart button is not visible.");


    }
}