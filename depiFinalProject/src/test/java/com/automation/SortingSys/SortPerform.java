package com.automation.SortingSys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortPerform {
    
    WebDriver myBrowser;

    private void selectSortOption(String value) {
        myBrowser.findElement(By.className("product_sort_container")).click();
        myBrowser.findElement(By.cssSelector("option[value=\"" + value + "\"]")).click();
    }

    Map<String, String> expectedFirstItems = Map.of(
    "az", "Sauce Labs Backpack",
    "za", "Test.allTheThings() T-Shirt (Red)",
    "lohi", "$7.99",
    "hilo", "$49.99"
    );

    String[] sortOptions = {"az", "za", "lohi", "hilo"};
    Random rand = new Random();

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();

        LoginHelper.performLogin(myBrowser);
    }


    @Test
    public void testSorting() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            String SelectedSort = sortOptions[rand.nextInt(sortOptions.length)];
            selectSortOption(SelectedSort);

            Thread.sleep(100);

            String expectedFirst = expectedFirstItems.get(SelectedSort);

            WebElement firstItem;
            if(SelectedSort.equals("az") || SelectedSort.equals("za")) {
                firstItem = myBrowser.findElements(By.className("inventory_item_name")).get(0);
            } else {
                firstItem = myBrowser.findElements(By.className("inventory_item_price")).get(0);
            }

            System.out.println("Sort: " + SelectedSort + " → Found: " + firstItem.getText());
            assertEquals(expectedFirst, firstItem.getText());
        }
    }


    @AfterEach
    public void tearDown() {
        if (myBrowser != null) {
            myBrowser.quit();
        }
    }
}
