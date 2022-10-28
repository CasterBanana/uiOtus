package test;


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
