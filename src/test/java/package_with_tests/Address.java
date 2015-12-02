package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Address {

    WebDriver driver;
    WebElement element;

    String errorMsgEmpty = "This field is mandatory";
    String errorMsgInvalid ="Please use only letters (a-z), numbers (0-9) and characters (,-'/#&)";
    String errorMsgLong = "Address should have 2-160 characters";
    String errorMsgShort = "Address should have 2-160 characters";

    public Address (WebDriver driver, By field){

        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){

        element.sendKeys(value);
    }

    public String getErrorMessage(){

        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[9]/div[3]")).getText();
    }
}
