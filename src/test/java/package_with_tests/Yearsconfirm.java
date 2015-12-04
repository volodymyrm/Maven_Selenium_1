package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Yearsconfirm {

    WebDriver driver;
    WebElement element;
    String errorMsgEmpty = "You must agree to our Terms and Conditions and Privacy policy in order to register an account";
    public Yearsconfirm(WebDriver driver, By field){

        this.driver = driver;
        element = driver.findElement(field);
    }

    public void click(){

        element.click();
    }

    public String getErrorMessage(){

        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[19]/div[3]")).getText();
    }
}
