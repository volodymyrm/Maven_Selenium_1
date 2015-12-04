package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Passwordconfirm {

    WebDriver driver;
    WebElement element;

    String errorMsgEmpty = "This field is mandatory";
    String errorMsgInvalid = "Please choose a password 5-10 characters long, using letters (a-z) and numbers (0-9) only";
    String errorMsgPassMissmatch = "The passwords you typed do not match";

    public Passwordconfirm(WebDriver driver, By field){

        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){

        element.sendKeys(value);
    }

    public String getErrorMessage(){

        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[14]/div[3]")).getText();
    }
}
