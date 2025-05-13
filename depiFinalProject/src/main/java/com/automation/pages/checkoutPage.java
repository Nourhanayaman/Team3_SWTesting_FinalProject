package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutPage {
    WebDriver driver;
   //locators
    By checkoutButton = By.className("checkout_button");
    By continueCheckoutButton = By.xpath("//input[@value='CONTINUE']");
    By finishButton = By.xpath("//a[@text()='FINISH']");
By firstName=By.id("first-name");
By lastName= By.id("last-name");
By zipCode =By.id("postal-code");
By ContinueCheckoutButton =By.xpath("//input[@value='CONTINUE'])");
By FinishButton =By.xpath("//a[@text()='FINISH'])");

    //constructor
    public checkoutPage(WebDriver driver) {
        this.driver = driver;
    }
        //actions

        public void clickcheckoutButton() {
            driver.findElement(checkoutButton).click();
        }
        public void enterFirstName(String firstNameText){
    driver.findElement(firstName).sendKeys(firstNameText);
    }
    public void enterLastName(String lastNameText){
        driver.findElement(lastName).sendKeys(lastNameText);
    }
public void enterpostalcode(String postalcodeText){
        driver.findElement(zipCode).sendKeys(postalcodeText);
}
public void clickContinueCheckOutButton(){driver.findElement(continueCheckoutButton).click();}
public void clickFinishButton(){
    driver.findElement(finishButton).click();
}

}

