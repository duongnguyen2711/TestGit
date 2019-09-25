package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//a[text()='Sign Up For Free']")
    public WebElement lnkSignUp;


    public void clickSignUp(){
    }

}
