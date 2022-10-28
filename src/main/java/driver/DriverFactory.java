package driver;

import exception.DriverNotSupportedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class DriverFactory implements IDriverFactory{
    private String browserType = System.getProperty("browser").toLowerCase(Locale.ROOT);


    @Override
    public WebDriver getDriver() throws DriverNotSupportedException {
        switch (this.browserType){
            case "chrome":{
                return new ChromeDriver();
            }
            default:
                throw new DriverNotSupportedException(this.browserType);

        }
    }
}
