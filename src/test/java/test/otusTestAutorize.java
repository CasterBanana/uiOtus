package test;



import driver.DriverFactory;
import driver.WebDriverFactory;
import exception.DriverNotSupportedException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class otusTestAutorize{
    MainPage page = new MainPage();

    @Test
    public void openOtusTest() throws InterruptedException {
        page.open();
        page.authorization();
    }
}
