package package_with_tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.basic.BasicArrowButton;

public class Tests {

    WebDriver driver;
    Page eg;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "\\Chromedriver\\chromedriver.exe");
       // eg = PageFactory.initElements(new ChromeDriver(), Page.class);

        driver = new ChromeDriver();

        //eg.open(Link.lnk);
        //eg.switchToFrame();
        driver.navigate().to(Link.lnk);
        driver.switchTo().frame(0);
    }

    @After
    public void thearDown(){
        driver.quit();
    }

    @Test
    public void testOne(){
        Page eg = new Page(driver);
        eg.typefName("VovaVova*&*");
        eg.typelName("KHKHHYJJ*");
        eg.submitRegistration();

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
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
