package Tests;

import TestComponents.BaseTest;
import framework.PageObjects.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidation extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void Test2(){
        ProductCatalogue productCatalogue = landingPage.enterApplication("asd@dasfa.lv","asaf");
        Assert.assertEquals("Incorrect email or password.", landingPage.getLoginErrorMessage());
    }
}
