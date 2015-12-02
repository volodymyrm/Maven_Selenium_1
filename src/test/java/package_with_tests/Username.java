package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Username {

    WebDriver driver;
    WebElement element;

    String errorMsgEmpty = "This field is mandatory";
    String errorMsgInvalid = "Please select a username using letters, numbers and characters (.-_@). 5-16 characters long";

    public Username(WebDriver driver, By field){

        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){

        element.sendKeys(value);
    }

    public String getErrorMessage(){

        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[12]/div[4]")).getText();
    }
}
