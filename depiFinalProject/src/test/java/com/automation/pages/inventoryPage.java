package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class inventoryPage {

    WebDriver inventoryDriver;

    //Locators
    public By productTitleLocator = By.className("inventory_item_name");
//    By burgerMenuLocator = By.xpath("//button[text()='Menu']");
    By burgerMenuLocator = By.className("shopping_cart_link");
    By logoutButtonLocator = By.id("logout_sidebar_link");
    By footerLocator = By.className("footer");
    By addToCartBtnLocator = By.className("shopping_cart_link.fa-layers.fa-fw");




    public inventoryPage(WebDriver driver) {
        this.inventoryDriver = driver;
    }
    public WebElement getProductTitle() {
        return inventoryDriver.findElement(productTitleLocator);
    }

    public loginPage  logOut() {
        inventoryDriver.findElement(burgerMenuLocator).click();
        waitForElementToBeClickable(logoutButtonLocator);
        inventoryDriver.findElement(logoutButtonLocator).click();
        return new loginPage(inventoryDriver);
    }



    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(inventoryDriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public  WebElement getFooter(){
        return inventoryDriver.findElement(footerLocator);
    }

    public WebElement waitForProductTitle() {
        new WebDriverWait(inventoryDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(productTitleLocator));
        return getProductTitle();
    }

}
