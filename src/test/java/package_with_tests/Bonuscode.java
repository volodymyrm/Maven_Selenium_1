package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bonuscode {

    WebDriver driver;
    WebElement element;

    String errorMsgInvalid = "The coupon you have chosen is invalid";

    public Bonuscode(WebDriver driver, By field){

        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){

        element.sendKeys(value);
    }

    public String getErrorMessage(){

        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[18]/div[3]")).getText();
    }
}
