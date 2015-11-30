package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cellphone {

    WebDriver driver;
    WebElement element;

    public Cellphone(WebDriver driver, By field){

        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){

        element.sendKeys(value);
    }

    public String getErrorMessage(){

        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[11]/div[3]")).getText();
    }
}
