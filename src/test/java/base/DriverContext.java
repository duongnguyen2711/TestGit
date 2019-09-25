package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverContext {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setUpDriver(){
        driver = Browser.setUpBwoserType();
    }

}
