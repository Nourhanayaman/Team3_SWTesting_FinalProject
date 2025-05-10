package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkout {
    WebDriver driver;
    By checkoutButton = By.className("checkout_button");
    By continueCheckoutButton = By.xpath("//input[@value='CONTINUE']");
    By finishButton = By.xpath("//a[@text()='FINISH']");
By firstName=By.id("first-name");
By lastName= By.id("last-name");
By zipCode =By.id("postal-code");

    //constructor
    public checkout(WebDriver driver) {
        this.driver = driver;
    }
        //actions

        public void checkoutButton() {
            driver.findElement(checkoutButton).click();
        }
public void enterFirstName( String firstName){
    driver.findElement(By.id("first-Name")).sendKeys("noureen");
    }
    public void enterLastName( String firstName) {
        driver.findElement(By.id("last-Name")).sendKeys("alaa");
    }
    public void enterPoastalCode( String postalcode) {
        driver.findElement(By.id("postal-code")).sendKeys("67668");
    }
    public void finishButton() {
        driver.findElement(finishButton).click();
    }



    }
