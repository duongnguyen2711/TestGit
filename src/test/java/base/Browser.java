package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static WebDriver driver;

    public static WebDriver setUpBwoserType(){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/data/driver" + "/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptSslCerts", true);
        driver = new ChromeDriver();

        return driver;
    }
}
