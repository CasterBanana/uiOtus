package pages;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage{
    private WebDriver driver;
    private final static String BASE_URL = System.getProperty("base.url");
    private final static String login = System.getProperty("username");
    private final static String password = System.getProperty("password");

    private String autorizeLocator = "//header//*[@data-modal-id='new-log-reg']";
    private String emailLocator = "//form/*/input[@type='text'][@placeholder='Электронная почта']";
    private String passwordLocator = "//form/*/input[@type='password'][@placeholder='Введите пароль']";
    private String enterLoginLocator = "//form/div/button[@type='submit' and contains(text(), 'Войти')]";


    public void open(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }
    public void authorization(){
        driver.findElement(By.xpath(autorizeLocator)).click();
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//form/*/input[@type='text'][@placeholder='Электронная почта']")));
        wait.sendKeys(login);
        driver.findElement(By.xpath(passwordLocator)).sendKeys(password);
        driver.findElement(By.xpath(enterLoginLocator)).click();
    }
}
