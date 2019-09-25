package page;

import base.Browser;
import base.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    @FindBy(xpath = ".//a[text()='Sign Up For Free']")
    public WebElement lnkSignUp;


    public LoginPage() throws InterruptedException {
        super();
        DriverContext.setUpDriver();
        DriverContext.getDriver().get("https://www.utest.com");
        DriverContext.getDriver().manage().window().maximize();
    }

    public void waitPageLoad(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
