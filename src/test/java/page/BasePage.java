package page;

import base.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

}
