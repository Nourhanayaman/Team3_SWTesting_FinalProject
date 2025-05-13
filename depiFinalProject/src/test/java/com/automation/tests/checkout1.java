import Pages.AddANDremoveCart;
import Pages.checkoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.automation.base.BaseTest;

public class checkout1 extends BaseTest {

    public class checkout1 {
        public WebDriver driver;
   checkoutPage checkoutPage=new checkoutPage(driver);
   AddANDremoveCart AddANDremoveCart=new AddANDremoveCart(driver);
    //public AddANDremoveCart AddANDremoveCart;
    //public checkoutPage checkoutPage;
    //checkoutPage 
        public WebDriverWait wait;
        public String pageTitle;

        @Test
            public void testRemoveProductFromCart() {
            AddANDremoveCart addCart= new AddANDremoveCart(driver);
                SoftAssert softAssert = new SoftAssert();
//add product to the cart
AddANDremoveCart.getPageTitleText();
               softAssert.assertEquals(pageTitle,"products","page title not as expected");

                AddANDremoveCart.clickCartButton();
//go to cart icon
                AddANDremoveCart cartIcon = AddANDremoveCart.clickCartIcon();
//confirm we are in cart page
//Click continue shopping
checkoutPage checkoutPage=new checkoutPage(driver);
checkoutPage.clickcheckoutButton();
checkoutPage.enterFirstName("noureen");
checkoutPage.enterLastName("alaa");
checkoutPage.enterpostalcode("84297");
checkoutPage.clickContinueCheckOutButton();
checkoutPage.clickFinishButton();

                WebElement confirmationMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
                softAssert.assertEquals(confirmationMessage.getText(),"THANK YOU FOR YOUR ORDER","Confirmation message as erxpected");
                softAssert.assertAll();


            }
        }






