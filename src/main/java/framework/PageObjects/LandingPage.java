package framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userEmail")
    WebElement userEmail;
    @FindBy(css = "#userPassword")
    WebElement password;

    @FindBy(css = "#login")
    WebElement loginBtn;

    @FindBy(css = ".toast-error")
    WebElement loginError;

    public ProductCatalogue enterApplication(String email, String pass) {
        userEmail.sendKeys(email);
        password.sendKeys(pass);
        loginBtn.click();
        return new ProductCatalogue(driver);
    }
public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
}
public String getLoginErrorMessage(){
        waitWebElementForAppear(loginError);
        return loginError.getText();
}
}
