package com.automation.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.automation.pages.ExpectedList;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseTest;

public class ProdSort extends BaseTest {

    private void selectSortOption(String value) {
        driver.findElement(By.className("product_sort_container")).click();
        driver.findElement(By.cssSelector("option[value=\"" + value + "\"]")).click();
    }
    
    @Test
    public void testSorting() throws InterruptedException {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        selectSortOption("az"); //First Sort Test
        Thread.sleep(1000);

        List<String> productNames = new ArrayList<>();
        List<WebElement> nameElements = driver.findElements(By.className("inventory_item_name"));

        for(WebElement element : nameElements) {
            productNames.add(element.getText());
        }

        List<String> expectedAZ = ExpectedList.sortedNamesAZ();
        assertEquals(productNames, expectedAZ);
        productNames.clear();

        selectSortOption("za"); //Second Sort Test
        Thread.sleep(1000);

        nameElements = driver.findElements(By.className("inventory_item_name"));

        for(WebElement element : nameElements) {
            productNames.add(element.getText());
        }

        List<String> expectedZA = ExpectedList.sortedNamesZA();
        assertEquals(productNames, expectedZA);
        productNames.clear();

        selectSortOption("lohi"); //Third Sort Test
        Thread.sleep(1000);

        List<String> productPrices = new ArrayList<>();
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

        for(WebElement element : priceElements) {
            productPrices.add(element.getText());
        }

        List<String> expectedLOHI = ExpectedList.sortedPricesLH();
        assertEquals(productPrices, expectedLOHI);
        productPrices.clear();

        selectSortOption("hilo"); //Fourth Sort Test
        Thread.sleep(1000);

        priceElements = driver.findElements(By.className("inventory_item_price"));

        for(WebElement element : priceElements) {
            productPrices.add(element.getText());
        }

        List<String> expectedHILO = ExpectedList.sortedPricesHL();
        assertEquals(productPrices, expectedHILO);
    }
}
