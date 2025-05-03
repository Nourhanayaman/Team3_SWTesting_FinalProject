package com.automation.SortingSys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortModeReset {
    

    WebDriver Browser;

    @BeforeEach
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        Browser = new ChromeDriver();
        Browser.manage().window().maximize();

        LoginHelper.performLogin(Browser);
    }

    @Test
    public void SortReset() throws InterruptedException {

        Browser.findElement(By.className("product_sort_container")).click();
        Browser.findElement(By.cssSelector("option[value='hilo']")).click(); //You can change to other opt ['lohi', 'za']
        Thread.sleep(500);

        String hiloOutput = Browser.findElement(By.className("inventory_item_name")).getText();
        String hiloExpected = "Sauce Labs Fleece Jacket";
        assertEquals(hiloOutput, hiloExpected);
        Thread.sleep(500);

        Actions refresh = new Actions(Browser);
        refresh.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).perform(); //First refresh method
        Thread.sleep(1000);

        WebElement sortDropdown = Browser.findElement(By.className("product_sort_container"));
        String selectedSortText = sortDropdown.getAttribute("value");
        System.out.println("First refresh, current sort value: " + selectedSortText);
        try {
            assertEquals("az", selectedSortText);
        } catch (AssertionError err) {
            System.out.println("Assertion Method 1 failed " + err.getMessage()); //Check debug console
        }

        Browser.navigate().refresh(); //Second refresh method
        Thread.sleep(2000);

        sortDropdown = Browser.findElement(By.className("product_sort_container"));
        selectedSortText = sortDropdown.getAttribute("value");
        System.out.println("Second refresh, current sort value: " + selectedSortText); //Check debug console
        assertEquals("az", selectedSortText);
    }

    @AfterEach
    public void tearDown() {
        if(Browser != null) {
            Browser.quit();
        }
    }
}
