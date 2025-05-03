package com.automation.SortingSys;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class ProdSort {

    WebDriver myBrowser;

    private void selectSortOption(String value) {
        myBrowser.findElement(By.className("product_sort_container")).click();
        myBrowser.findElement(By.cssSelector("option[value=\"" + value + "\"]")).click();
    }
    

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();

        LoginHelper.performLogin(myBrowser);
    }

    @Test
    public void testSorting() throws InterruptedException {
        selectSortOption("az"); //First Sort Test
        Thread.sleep(1000);

        List<String> ProductNames = new ArrayList<>();
        List<WebElement> nameElements = myBrowser.findElements(By.className("inventory_item_name"));

        for(WebElement element : nameElements) {
            ProductNames.add(element.getText());
        }

        List<String> ExpectedAZ = ExpectedList.SortedNamesAZ();
        assertEquals(ExpectedAZ, ProductNames);
        ProductNames.clear();

        selectSortOption("za"); //Second Sort Test
        Thread.sleep(1000);

        nameElements = myBrowser.findElements(By.className("inventory_item_name"));

        for(WebElement element : nameElements) {
            ProductNames.add(element.getText());
        }

        List<String> ExpectedZA = ExpectedList.SortedNamesZA();
        assertEquals(ExpectedZA, ProductNames);
        ProductNames.clear();

        selectSortOption("lohi"); //Third Sort Test
        Thread.sleep(1000);

        List<String> ProductPrices = new ArrayList<>();
        List<WebElement> PriceElements = myBrowser.findElements(By.className("inventory_item_price"));

        for(WebElement element : PriceElements) {
            ProductPrices.add(element.getText());
        }

        List<String> ExpectedLOHI = ExpectedList.SortedPricesLH();
        assertEquals(ExpectedLOHI, ProductPrices);
        ProductPrices.clear();

        selectSortOption("hilo"); //Fourth Sort Test
        Thread.sleep(1000);

        PriceElements = myBrowser.findElements(By.className("inventory_item_price"));

        for(WebElement element : PriceElements) {
            ProductPrices.add(element.getText());
        }

        List<String> ExpectedHILO = ExpectedList.SortedPricesHL();
        assertEquals(ExpectedHILO, ProductPrices);

    }

    @AfterEach
    public void tearDown() {
        if (myBrowser != null) {
            myBrowser.quit();
        }
    }
}
