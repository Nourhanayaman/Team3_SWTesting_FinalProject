import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;

    public class checkout1 {
        public WebDriver driver;
        public WebDriverWait wait;


            @Test
            public void testRemoveProductFromCart() {
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
                WebElement continueShopping=driver.findElement(By.className("btn_secondary"));
                continueShopping.click();
                driver.findElement(By.className("checkout_button")).click();
                //fill checkout fields
                driver.findElement(By.id("first-name")).sendKeys("noureen");
                driver.findElement(By.id("last-name")).sendKeys("alaa");
                driver.findElement(By.id("postal-code")).sendKeys("67668");
                //click continue doesntwork
                driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
                //continue
                //then click finish
                driver.findElement(By.xpath("//a[@text()='FINISH']")).click();
                //assert the confirmation message
                WebElement confirmationMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
                softAssert.assertEquals(confirmationMessage.getText(),"THANK YOU FOR YOUR ORDER","Confirmation message as erxpected");
                softAssert.assertAll();


            }
        }






