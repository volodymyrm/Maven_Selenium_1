package package_with_tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {

    @Test
    public void startWebDriver(){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://Google.com");

        driver.close();
    }

}
