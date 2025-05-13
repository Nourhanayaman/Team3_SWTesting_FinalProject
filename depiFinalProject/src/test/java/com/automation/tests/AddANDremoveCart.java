package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddANDremoveCart {
    WebDriver driver;
//Locators
    By pageTitle =By.className("product_label");
    By addToCartButton=By.xpath("(//button[@class='btn_primary btn_inventory'])[1]");
    By cartIcon=By.className("shopping_cart_link");
    By clickContinueShopping =By.className("checkout_button");
    By removeButton =By.xpath("//button[@class='cart_button']");
By cartItemRemove =By.className("cart_item");


//constructor
public AddANDremoveCart(WebDriver driver) {
this.driver = driver;
}


//methods/actions
    public static void clickCartButton() {
    }
    public static AddANDremoveCart clickCartIcon() {
        return null;
    }


    public static void clickContinueShopping() {
    }


    public static void getPageTitleText() {
    }

    public static void clickRemoveButton(){

    }
    public static void cartItemRemove(){

    }


    }








