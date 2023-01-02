package framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends AbstractComponents{
    public WebDriver driver;



    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "[placeholder = 'Select Country']")
    WebElement country;
    @FindBy(css = ".btnn")
    WebElement placeOrderBtn;

    @FindBy(css = ".ta-item:nth-of-type(2)")
    WebElement indiaCountry;

    @FindBy (css = ".hero-primary")
    WebElement confirmationMsg;
    public void fulfillPaymentForm(String nameOfCountry){
country.sendKeys(nameOfCountry);
indiaCountry.click();
placeOrderBtn.click();
    }
    public String getConfirmationMessage(){
        return confirmationMsg.getText();
    }
}
