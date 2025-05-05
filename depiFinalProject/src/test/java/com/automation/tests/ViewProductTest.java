
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

import java.util.List;
import com.automation.dataProviders.users;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.bouncycastle.cms.RecipientId.password;
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
        public void checkProductsForUser(String username, String password) throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://www.saucedemo.com/v1/index.html");


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));


            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-button")).click();

            System.out.println("\n🚀 Testing user: " + username);


            wait.until(ExpectedConditions.urlContains("inventory.html"));
            Thread.sleep(1000);


            List<WebElement> products = driver.findElements(By.className("inventory_item"));
            if (products.isEmpty()) {
                System.err.println("❌ No products found for user: " + username);
                return;
            }


            for (WebElement product : products) {
                Thread.sleep(800); // Delay for demo purpose

                try {
                    WebElement title = wait.until(ExpectedConditions.visibilityOf(product.findElement(By.className("inventory_item_name"))));
                    WebElement image = product.findElement(By.cssSelector(".inventory_item_img img"));
                    WebElement description = product.findElement(By.className("inventory_item_desc"));

                    String titleText = title.getText().trim();
                    String imageSrc = image.getAttribute("src").trim();
                    String descText = description.getText().trim();


                    boolean imageVisible = isImageLoadedAndVisible(image);
                    boolean descriptionPresent = !descText.isEmpty();


                    System.out.println("🔍 Product: " + titleText);
                    System.out.println("    Image loaded and visible: " + imageVisible);
                    System.out.println("    Description present: " + descriptionPresent);
                    System.out.println("    Image URL: " + imageSrc);


                    if (!imageVisible) {
                        System.err.println("❌ Error: Image not loaded or visible for product: " + titleText);
                    }

                    if (!descriptionPresent) {
                        System.err.println("❌ Error: Description is empty for product: " + titleText);
                    }

                } catch (NoSuchElementException | TimeoutException e) {
                    System.err.println("❌ Element error for user " + username + ": " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("❌ Unexpected error: " + e.getMessage());
                }
            }
        }


        private boolean isImageLoadedAndVisible(WebElement image) {
            try {

                boolean isDisplayed = image.isDisplayed();
                if (!isDisplayed) {
                    return false;
                }


                JavascriptExecutor js = (JavascriptExecutor) driver;
                Long naturalWidth = (Long) js.executeScript("return arguments[0].naturalWidth;", image);
                Long naturalHeight = (Long) js.executeScript("return arguments[0].naturalHeight;", image);


                if (naturalWidth == 0 || naturalHeight == 0) {
                    return false;
                }


                return true;

            } catch (Exception e) {
                System.err.println("Error checking image load and visibility: " + e.getMessage());
                return false;
            }
        }
    }




























