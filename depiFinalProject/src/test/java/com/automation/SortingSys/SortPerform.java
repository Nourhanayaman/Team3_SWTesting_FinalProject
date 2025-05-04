package com.automation.SortingSys;

import static org.testng.Assert.assertEquals;

import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseTest;

public class SortPerform extends BaseTest {
    
    private void selectSortOption(String value) {
        driver.findElement(By.className("product_sort_container")).click();
        driver.findElement(By.cssSelector("option[value=\"" + value + "\"]")).click();
    }

    Map<String, String> expectedFirstItems = Map.of(
        "az", "Sauce Labs Backpack",
        "za", "Test.allTheThings() T-Shirt (Red)",
        "lohi", "$7.99",
        "hilo", "$49.99"
    );

    String[] sortOptions = {"az", "za", "lohi", "hilo"};
    Random rand = new Random();

    @Test
    public void testSorting() throws InterruptedException {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        for (int i = 0; i < 50; i++) {
            String selectedSort = sortOptions[rand.nextInt(sortOptions.length)];
            selectSortOption(selectedSort);

            Thread.sleep(100);

            String expectedFirst = expectedFirstItems.get(selectedSort);

            WebElement firstItem;
            if(selectedSort.equals("az") || selectedSort.equals("za")) {
                firstItem = driver.findElements(By.className("inventory_item_name")).get(0);
            } else {
                firstItem = driver.findElements(By.className("inventory_item_price")).get(0);
            }

            System.out.println("Sort: " + selectedSort + " → Found: " + firstItem.getText());
            assertEquals(firstItem.getText(), expectedFirst);
        }
    }
}
