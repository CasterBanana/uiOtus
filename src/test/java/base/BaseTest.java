package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import test.OtusWebCabinet;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(OtusWebCabinet.class);
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @AfterTest
    public void setDown(){
        if(driver!= null)
            driver.quit();
    }

    public void fillField(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
}
