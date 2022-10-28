package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsBasePage {
    private final static String BASE_URL = System.getProperty("base.url");

    protected WebDriver driver;

    public AbsBasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void open(String path) {
        driver.get(BASE_URL + path);
    }


}
