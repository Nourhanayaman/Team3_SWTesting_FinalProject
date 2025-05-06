import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class checkout2  {
    public WebDriver driver;
    public WebDriverWait wait;

        @Test
        public void
        testRemoveProductFromCart() {
            SoftAssert softAssert = new SoftAssert();
//add product to the cart
            WebElement addToCartButton = driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[1]"));

            addToCartButton.click();
//go to cart icon
            WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
            cartIcon.click();
//confirm we are in cart page
            softAssert.assertTrue(driver.getCurrentUrl().contains("cart"), "not on Cart page");
//Click continue shopping
            WebElement continueShopping = driver.findElement(By.className("btn_secondary"));
            continueShopping.click();
            driver.findElement(By.className("checkout_button")).click();
            //fill checkout fields
            driver.findElement(By.id("first-name")).sendKeys("80948");
            driver.findElement(By.id("last-name")).sendKeys("55476");
            driver.findElement(By.id("postal-code")).sendKeys("67668");
            //click continue doesntwork
            driver.findElement(By.className("cart_button")).click();
            //continue
            //verify that user didnt proceed to the next step
            String currenturl=driver.getCurrentUrl();
            softAssert.assertFalse(currenturl.contains("checkOutStepTwo"),"user incorrectly moved to next step with invalid input");
            //check if error message shown
softAssert.assertFalse(driver.findElements(By.cssSelector("[data-test='error']")).isEmpty(),"Expected error message not shown");
softAssert.assertAll();





        }
    }
