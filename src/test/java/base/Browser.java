package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
    private static WebDriver driver;
    public BrowserType browserType;

    public static WebDriver setUpBwoserType(BrowserType browserType){
        switch (browserType){
            case IE:
                System.setProperty("webdriver.ie.driver", "C:\\MavenDemoTest\\driver");
                driver = new InternetExplorerDriver();

            case Chrome:
                System.setProperty("webdriver.ie.driver", "C:\\Working\\SourceCode\\Utilisoft\\automation-utilisoft\\data\\webdriver");
                driver = new InternetExplorerDriver();

            case Firefox:
                System.setProperty("webdriver.ie.driver", "C:\\Working\\SourceCode\\Utilisoft\\automation-utilisoft\\data\\webdriver");
                driver = new InternetExplorerDriver();
        }
    }
}
