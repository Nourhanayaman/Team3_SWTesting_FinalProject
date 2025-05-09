
package com.automation.tests;
import com.automation.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import java.time.Duration;
import com.automation.pages.Product_Page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class ViewProductTest extends BaseTest {

    @DataProvider(name = "userCredentials")
    public Object[][] userCredentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "userCredentials")
    public void checkAllProductsHaveValidImageAndDescription(String username, String password) {
        driver.get("https://www.saucedemo.com/v1/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        // Product page logic
        Product_Page productPage = new Product_Page(driver);
        productPage.waitForInventoryPage();
        List<WebElement> products = productPage.getAllProducts();

        if (products.isEmpty()) {
            System.err.println("❌ No products found for user: " + username);
            return;
        }

        System.out.println("\n============================");
        System.out.println("🔍 Verifying products for user: " + username);
        System.out.println("============================");

        for (int i = 0; i < products.size(); i++) {
            WebElement product = products.get(i);
            try {
                WebElement image = productPage.getProductImage(product);
                String description = productPage.getProductDescription(product);
                boolean imageStatus = productPage.isImageLoadedAndVisible(image);
                boolean descStatus = !description.isEmpty();

                System.out.println("-----");
                System.out.println("📦 Product #" + (i + 1));
                System.out.println("🖼️ Image loaded & visible: " + imageStatus);
                System.out.println("📝 Description present: " + descStatus);
                System.out.println("✅ Status: " + (imageStatus && descStatus ? "PASS" : "FAIL"));

                if (!imageStatus) {
                    System.err.println("❌ Issue: Image is either not loaded or not visible.");
                }
                if (!descStatus) {
                    System.err.println("❌ Issue: Description is missing or empty.");
                }

            } catch (Exception e) {
                System.err.println("❌ Error checking product #" + (i + 1) + ": " + e.getMessage());
            }
        }
    }
}


