package package_with_tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {

    private final WebDriver driver = new FirefoxDriver();
    private final Page eg = new Page(driver);

    @Before
    public void setUp(){
        driver.navigate().to(Link.lnk);
    }
    @After
    public void thearDown(){
        driver.close();
    }

    @Test
    public void testOne(){
        eg.typefName("hkjhkjhkj&");
        eg.typelName("KHKHHYJJ*");
        eg.submitRegistration();
        driver.close();
    }

    @Test
    public void testTwo(){
        eg.typefName("VVVVVVV66^^^");
        eg.typelName("VVVVVVV66^^^");
        eg.submitRegistration();
        driver.close();
    }


}
