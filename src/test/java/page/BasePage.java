package page;

import base.DriverContext;
import com.sun.xml.internal.messaging.saaj.soap.impl.ElementFactory;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        driver = DriverContext.getDriver();
    }

}
