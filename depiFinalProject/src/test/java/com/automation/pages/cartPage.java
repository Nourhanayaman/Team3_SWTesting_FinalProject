package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class cartPage {
    WebDriver addToCartDriver;

    public By CartBtnLocator = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By cartIcon = By.xpath("//svg[@data-icon='shopping-cart']");
   public By CartCounter = By.xpath("//a[contains(@class, 'shopping_cart_link')]//span[contains(@class, 'shopping_cart_badge')]");
   By removeBtnP1 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button");



    // By addToCartBtnLocator = By.className("shopping_cart_link.fa-layers.fa-fw");
    public cartPage(WebDriver driver) {
        this.addToCartDriver = driver;
    }

    public void clickCart() {
        this.addToCartDriver.findElement(CartBtnLocator).click();
    }

    public int getCartItemCount() {
        WebDriverWait wait = new WebDriverWait(addToCartDriver, Duration.ofSeconds(20));
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(CartCounter));

        // Wait until text is non-empty (counter appears with a number)
        wait.until(driver -> !badge.getText().trim().isEmpty());

        return Integer.parseInt(badge.getText().trim());
    }
    public void clickRemoveBtnP1() {
        this.addToCartDriver.findElement(removeBtnP1).click();
    }
}
