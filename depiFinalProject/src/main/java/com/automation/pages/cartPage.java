package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cartPage {
    WebDriver addToCartDriver;


    public By CartBtnLocator = By.id("shopping_cart_container");
    public By CartCounter = By.cssSelector("a.shopping_cart_link > span.shopping_cart_badge");
    public By removeBtnP1 = By.cssSelector("#cart_contents_container .cart_item:nth-child(3) .item_pricebar button");


    public cartPage(WebDriver driver) {

        this.addToCartDriver = driver;
    }

    public void clickCart() {

        this.addToCartDriver.findElement(CartBtnLocator).click();
    }

    public int getCartItemCount() {
        WebDriverWait wait = new WebDriverWait(addToCartDriver, Duration.ofSeconds(20));
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(CartCounter));
        wait.until(driver -> !badge.getText().trim().isEmpty());  // Wait until text is non-empty (counter appears with a number)
        return Integer.parseInt(badge.getText().trim());
    }
    public void clickRemoveBtnP1() {
        this.addToCartDriver.findElement(removeBtnP1).click();
    }
}
