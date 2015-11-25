package package_with_tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {

    Page eg;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        eg = new Page(driver);
        eg.open(Link.lnk);
        eg.switchToFrame();
    }

    @After
    public void thearDown(){
        eg.close();
    }

    @Test
    public void testOne(){
        eg.typefName("HJGFjgj3*");
        eg.typelName("HJGFjgj3*");
        //eg.setDOB("20", "06", "1990");
        //eg.setTitle("Mr");
        eg.typeEmail("HJGFjgj3*");
        //eg.setCountry("GB");
        eg.typeCity("HJGFjgj3*");
        eg.typeAddress("HJGFjgj3*");
        eg.typeZip("1234567890123");
        eg.typeCellphone("HJGFjgj3*");
        eg.typeUname("HJGFjgj3*");
        eg.typePassword("HJGFjgj3*");
        eg.typeConfirmPass("HJGFjgj3*");
        //eg.setDepositLimit("0");
        //eg.submitYearsConfirm();
        eg.submitEmailSubscription();
        eg.submitRegistration();

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
