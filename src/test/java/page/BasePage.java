package page;

import base.DriverContext;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        driver = DriverContext.getDriver();
    }

}
