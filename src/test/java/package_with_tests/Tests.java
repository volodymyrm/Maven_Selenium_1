package package_with_tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Tests {

    Page eg;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "\\Chromedriver\\chromedriver.exe");
        eg = PageFactory.initElements(new ChromeDriver(), Page.class);
        eg.open("http://m-stg-admin.williamhillcasino.com/register2");
        eg.switchToFrame();
        //driver.navigate().to(Link.lnk);
        //driver.switchTo().frame(0);
    }

    @After
    public void thearDown(){
        eg.close();
    }

    @Test
    public void testOne(){
        eg.typefName("VovaVova*&*");
        eg.typelName("KHKHHYJJ*");
     //   eg.setDOB("20");
        eg.submitRegistration();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

  /*  @Test
    public void testTwo(){
        Page eg = new Page(driver);
        eg.typefName("VVVVVVV66^^^");
        eg.typelName("VVVVVVV66^^^");
        eg.submitRegistration();
        driver.close();
    }*/
}
