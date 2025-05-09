package com.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

    public class Product_Page {
        private WebDriver driver;
        private WebDriverWait wait;

        public Product_Page(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void waitForInventoryPage() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));
        }

        public List<WebElement> getAllProducts() {
            return driver.findElements(By.className("inventory_item"));
        }

        public WebElement getProductImage(WebElement product) {
            return product.findElement(By.cssSelector(".inventory_item_img img"));
        }

        public String getProductDescription(WebElement product) {
            return product.findElement(By.className("inventory_item_desc")).getText().trim();
        }

        public boolean isImageLoadedAndVisible(WebElement image) {
            try {
                boolean isDisplayed = image.isDisplayed();
                Long naturalWidth = (Long) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].naturalWidth", image);
                return isDisplayed && naturalWidth != null && naturalWidth > 0;
            } catch (Exception e) {
                return false;
            }
        }
    }


