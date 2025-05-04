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
    public By burgerMenuLocator =By.cssSelector(".bm-burger-button > button");
    public By logoutButtonLocator = By.id("logout_sidebar_link");
    By footerLocator = By.className("footer");
//    By CartBtnLocator = By.className("shopping_cart_link.fa-layers.fa-fw");
    By product1BtnLocator = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button");
    By product2BtnLocator = By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button");
    By product3BtnLocator = By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button");
    By product4BtnLocator = By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[3]/button");
    By product5BtnLocator = By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button");
    By product6BtnLocator = By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[3]/button");



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

    public  WebElement getFooter(){
        return inventoryDriver.findElement(footerLocator);
    }

    public WebElement waitForProductTitle() {
        new WebDriverWait(inventoryDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(productTitleLocator));
        return getProductTitle();
    }



    public void clickOnMenuBtn(){
        inventoryDriver.findElement(burgerMenuLocator).click();
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


//    public cartPage clickOnCart() {
//        inventoryDriver.findElement(CartBtnLocator).click();
//        return new cartPage(inventoryDriver);
//    }
//    public void addAllProductsToCart() {
//        List<WebElement> buttons = inventoryDriver.findElements(addToCartButtons);
//        for (WebElement btn : buttons) {
//            btn.click();
//        }
//        // Wait until cart is updated (i.e., items are in cart)
//        new WebDriverWait(inventoryDriver, Duration.ofSeconds(5)).until(driver ->
//                driver.findElements(removeFromCartButtons).size() == buttons.size()
//        );
//    }
//
//
//   public void removeFromCart() {
//        inventoryDriver.findElement(removeFromCartButtons).click();
//   }
//
//    public int getCountOfProductsInCart() {
//        int   count = inventoryDriver.findElements(removeFromCartButtons).size();
//        return count;
//    }

}
