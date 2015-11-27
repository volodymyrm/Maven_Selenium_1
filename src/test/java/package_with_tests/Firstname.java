package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Firstname {

    WebDriver driver;
    WebElement firstname;

    public Firstname(WebDriver driver, By firstnameField) {
        this.driver = driver;
        firstname = driver.findElement(firstnameField);
    }

    public void setValue(String firstnameValue){
        firstname.sendKeys(firstnameValue);
    }
}
