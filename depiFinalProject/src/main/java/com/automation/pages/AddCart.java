package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class  AddCart{
    WebDriver driver;
//    By addToCartButton=By.xpath("//button[@class='btn_inventory'][1])");
By addToCartButton = By.xpath("(//button[contains(@class, 'btn_inventory')])[1]");

    By cartIcon=By.className("shopping_cart_link");
        //constructor
public AddCart(WebDriver driver) {
this.driver = driver;
}
//methods/actions
    public void clickAddCart(){
    driver.findElement(addToCartButton).click();
    }
public void goToCartIcon(){
    driver.findElement(cartIcon).click();
}
public removeProduct clickCartIcon(){
    driver.findElement(cartIcon).click();
    return new
            removeProduct(driver);
}
}
