package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Firstname {

    WebDriver driver;
    WebElement element;

    String errorMsgEmpty = "This field is mandatory";
    String errorMsgLong = "First name should have 1-50 characters";
    String errorMsgInvalid = "Please only use letters (a-z) and characters (,-.)";

    public Firstname(WebDriver driver, By field) {
        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){
        element.sendKeys(value);
    }

    public String getErrorMessage(){
        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[1]/div[3]")).getText();
    }
}
