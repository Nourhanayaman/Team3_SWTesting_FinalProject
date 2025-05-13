import Pages.AddANDremoveCart;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import com.automation.base.BaseTest;

public class removefromcart extends BaseTest {

    private static Object removeButton;
    public WebDriver driver;
    //public AddANDremoveCart AddANDremoveCart;
   AddANDremoveCart AddANDremoveCart=new AddANDremoveCart(driver);

    public WebDriverWait wait;
    public String pageTitle;


    @Test
    public void testRemoveProductFromCart() {
        AddANDremoveCart addCart = new AddANDremoveCart(driver);
        SoftAssert softAssert = new SoftAssert();
        AddANDremoveCart.getPageTitleText();
        softAssert.assertEquals(pageTitle, "products", "page title not as expected");
        AddANDremoveCart.clickCartButton();
        AddANDremoveCart cartIcon;
        cartIcon = AddANDremoveCart.clickCartIcon();

        softAssert.assertTrue(driver.getCurrentUrl().contains("cart"), "not on Cart page");
        AddANDremoveCart.clickRemoveButton();
        WebDriverWait wait = new
                WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_icon")));
            softAssert.assertTrue(true, "product removed successfully,cart is empty");
        } catch (TimeoutException e) {
            //WebElement cartItemRemoved=driver.findElement(By.className("cart_item"));
            softAssert.fail("cart is not empty after removing the product.");
        }
        softAssert.assertAll();
    }


    public void main() {
    }

