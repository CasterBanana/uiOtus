package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory implements IWebDriverFactory {
    private String browserType;
    private String options;

    public WebDriverFactory(String browserType, String options){
        this.browserType = browserType;
        this.options = options;

    }
    public WebDriverFactory(String browserType){
        this.browserType = browserType;
    }

    @Override
    public WebDriver create() {
        switch (this.browserType) {
            case "chrome": {
                return new ChromeDriver();
            }
            case "firefox":{
                return new FirefoxDriver();
            }
            default:
                System.out.println("Такой браузер не поддерживается" + this.browserType);
                return null;
        }


    }
}
