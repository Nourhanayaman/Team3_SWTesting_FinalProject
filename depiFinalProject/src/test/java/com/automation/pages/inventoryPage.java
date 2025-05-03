package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class inventoryPage {

    WebDriver inventoryDriver;

    //Locators
    public By productTitleLocator = By.className("inventory_item_name");
    By burgerMenuLocator = By.className("shopping_cart_link");
    By logoutButtonLocator = By.id("logout_sidebar_link");
    By footerLocator = By.className("footer");
    By CartBtnLocator = By.className("shopping_cart_link.fa-layers.fa-fw");
    By cartIcon = By.xpath("//svg[@data-icon='shopping-cart']");
    By addToCartButtons = By.className("btn_primary.btn_inventory");
    By removeFromCartButtons = By.className("btn_secondary.btn_inventory");


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

    public cartPage clickOnCart() {
        inventoryDriver.findElement(CartBtnLocator).click();
        return new cartPage(inventoryDriver);
    }
    public void addAllProductsToCart() {
        List<WebElement> buttons = inventoryDriver.findElements(addToCartButtons);
        for (WebElement btn : buttons) {
            btn.click();
        }
        // Wait until cart is updated (i.e., items are in cart)
        new WebDriverWait(inventoryDriver, Duration.ofSeconds(5)).until(driver ->
                driver.findElements(removeFromCartButtons).size() == buttons.size()
        );
    }


   public void removeFromCart() {
        inventoryDriver.findElement(removeFromCartButtons).click();
   }

    public int getCountOfProductsInCart() {
        int   count = inventoryDriver.findElements(removeFromCartButtons).size();
        return count;
    }

}
