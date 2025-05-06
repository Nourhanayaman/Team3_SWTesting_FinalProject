import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class removefromcart {
    public WebDriver driver;
    public WebDriverWait wait;


    @Test
    public void testRemoveProductFromCart() {
        SoftAssert softAssert = new SoftAssert();
//add product to the cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='btn_inventory']"));
        addToCartButton.click();
//go to cart icon
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
//confirm we are in cart page
        //remove product from cart one product only
        softAssert.assertTrue(driver.getCurrentUrl().contains("cart"), "not on Cart page");
WebElement removeButton=driver.findElement(By.xpath("//button[@class='cart_button']"));
removeButton.click();
try {
    WebElement cartItemRemoved=driver.findElement(By.className("cart_item"));
    softAssert.fail("cart is not empty after removing the product.");
} catch (org.openqa.selenium.NoSuchElementException e) {
    softAssert.assertTrue(true,"product removed successfully,cart is empty");
}
softAssert.assertAll();
}


    }
