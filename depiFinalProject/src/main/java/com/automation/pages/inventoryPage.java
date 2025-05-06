package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class inventoryPage {

    WebDriver inventoryDriver;

    //Locators
    public By productTitleLocator = By.className("inventory_item_name");
    public By logoutButtonLocator = By.id("logout_sidebar_link");
    By product1BtnLocator = By.cssSelector("#inventory_container > div > div:nth-child(1) > div:nth-child(3) > button");
    By product2BtnLocator = By.cssSelector("#inventory_container > div > div:nth-child(2) > div:nth-child(3) > button");
    By product3BtnLocator = By.cssSelector("#inventory_container > div > div:nth-child(3) > div:nth-child(3) > button");
    By product4BtnLocator = By.cssSelector("#inventory_container > div > div:nth-child(4) > div:nth-child(3) > button");
    By product5BtnLocator = By.cssSelector("#inventory_container > div > div:nth-child(5) > div:nth-child(3) > button");
    By product6BtnLocator = By.cssSelector("#inventory_container > div > div:nth-child(6) > div:nth-child(3) > button");




    public inventoryPage(WebDriver driver) {

        this.inventoryDriver = driver;
    }
    public WebElement getProductTitle() {

        return inventoryDriver.findElement(productTitleLocator);
    }

    public loginPage  logOut() {

        waitForElementToBeClickable(logoutButtonLocator);
        inventoryDriver.findElement(logoutButtonLocator).click();
        return new loginPage(inventoryDriver);
    }



    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(inventoryDriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void clickOnaddToCartP1(){

        inventoryDriver.findElement(product1BtnLocator).click();
    }
    public void clickOnaddToCartP2(){
        inventoryDriver.findElement(product2BtnLocator).click();

    }
    public void clickOnaddToCartP3(){

        inventoryDriver.findElement(product3BtnLocator).click();
    }
    public void clickOnaddToCartP4(){

        inventoryDriver.findElement(product4BtnLocator).click();
    }
    public void clickOnaddToCartP5(){

        inventoryDriver.findElement(product5BtnLocator).click();
    }
    public void clickOnaddToCartP6(){

        inventoryDriver.findElement(product6BtnLocator).click();
    }



}
