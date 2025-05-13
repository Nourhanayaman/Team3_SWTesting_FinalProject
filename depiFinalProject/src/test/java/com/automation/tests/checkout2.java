import Pages.AddANDremoveCart;
import Pages.checkoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class checkout2  {
    public WebDriver driver;
    checkoutPage checkoutPage=new checkoutPage(driver);
    AddANDremoveCart AddANDremoveCart=new AddANDremoveCart(driver);
    public WebDriverWait wait;
    public String pageTitle;

        @Test
        public void
        testRemoveProductFromCart() {
            SoftAssert softAssert = new SoftAssert();
            AddANDremoveCart.getPageTitleText();
            softAssert.assertEquals(pageTitle, "products", "page title not as expected");
            AddANDremoveCart.clickCartButton();
            AddANDremoveCart cartIcon = AddANDremoveCart.clickCartIcon();

//confirm we are in cart page
//Click continue shopping
            checkoutPage checkoutPage = new checkoutPage(driver);
            checkoutPage.clickcheckoutButton();
            checkoutPage.enterFirstName("98904");
            checkoutPage.enterLastName("76578");
            checkoutPage.enterpostalcode("84297");
            checkoutPage.clickContinueCheckOutButton();
            checkoutPage.clickFinishButton();

//user not proceed to the next step
            String currenturl=driver.getCurrentUrl();
            softAssert.assertFalse(currenturl.contains("checkOutStepTwo"),"user incorrectly moved to next step with invalid input");
            //check if error message shown
            softAssert.assertFalse(driver.findElements(By.cssSelector("[data-test='error']")).isEmpty(),"Expected error message not shown");
            softAssert.assertAll();



        }
}
