package framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponents {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    By checkoutBy = By.xpath("//button[text()='Checkout']");

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkout;

public PaymentPage checkoutCart(){
        checkout.click();
        return new PaymentPage(driver);
}
}
