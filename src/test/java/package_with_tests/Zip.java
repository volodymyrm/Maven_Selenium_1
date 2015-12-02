package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zip {

    WebDriver driver;
    WebElement element;

    String errorMsgEmpty = "This field is mandatory";
    //String errorMsgInvalid = "Please enter your postal code using letters (a-z), numbers (0-9) and characters (_-/)";

    public Zip(WebDriver driver, By field){

        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){

        element.sendKeys(value);
    }

    public String getErrorMessage(){

        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[10]/div[3]")).getText();
    }
}
