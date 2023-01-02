package Tests;

import TestComponents.BaseTest;
import framework.PageObjects.CartPage;
import framework.PageObjects.OrderPage;
import framework.PageObjects.PaymentPage;
import framework.PageObjects.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceTheOrder extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test
    public void someTest() {
        ProductCatalogue productCatalogue = landingPage
                .enterApplication("bidakag438@chnlog.com", "!Qwertyuiop1");
        productCatalogue.addProductToCart(productName);
        CartPage cart = productCatalogue.clickToCartBtn();
        PaymentPage paymentPage = cart.checkoutCart();
        paymentPage.fulfillPaymentForm("India");
        Assert.assertEquals("THANKYOU FOR THE ORDER.", paymentPage.getConfirmationMessage());
    }

    @Test(dependsOnMethods = {"someTest"})
    public void orderHistory() {
        ProductCatalogue productCatalogue = landingPage
                .enterApplication("bidakag438@chnlog.com", "!Qwertyuiop1");
        OrderPage orderPage = landingPage.goToOrders();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }
}
