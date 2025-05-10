package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class removeProduct {
    WebDriver driver;
    By removeButton = By.xpath("//button[@class()='cart_button']");
//constructor
    public removeProduct(WebDriver driver) {
        this.driver = driver;
    }
//actions
    public void removeProduct() {
        driver.findElement(removeButton).click();
    }


    }
