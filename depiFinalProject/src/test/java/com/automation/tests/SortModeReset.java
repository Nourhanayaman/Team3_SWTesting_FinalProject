package com.automation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.BaseTest;

public class SortModeReset extends BaseTest {
    
    @Test
    public void sortReset() throws InterruptedException {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        // Select high to low sort option
        driver.findElement(By.className("product_sort_container")).click();
        driver.findElement(By.cssSelector("option[value='hilo']")).click(); //You can change to other opt ['lohi', 'za']
        Thread.sleep(500);

        String hiloOutput = driver.findElement(By.className("inventory_item_name")).getText();
        String hiloExpected = "Sauce Labs Fleece Jacket";
        assertEquals(hiloOutput, hiloExpected);
        Thread.sleep(500);

        Actions refresh = new Actions(driver);
        refresh.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).perform(); //First refresh method
        Thread.sleep(1000);

        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        String selectedSortText = sortDropdown.getAttribute("value");
        System.out.println("First refresh, current sort value: " + selectedSortText);
        try {
            assertEquals(selectedSortText, "az");
        } catch (AssertionError err) {
            System.out.println("Assertion Method 1 failed " + err.getMessage()); //Check debug console
        }

        driver.navigate().refresh(); //Second refresh method
        Thread.sleep(2000);

        sortDropdown = driver.findElement(By.className("product_sort_container"));
        selectedSortText = sortDropdown.getAttribute("value");
        System.out.println("Second refresh, current sort value: " + selectedSortText); //Check debug console
        assertEquals(selectedSortText, "az");
    }
}
