package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Email {

    WebDriver driver;
    WebElement email;

    public Email(WebDriver driver, By emailField) {
        this.driver = driver;
        email = driver.findElement(emailField);
    }

     public void typeEmail(String emailvalue){
         email.sendKeys(emailvalue);
    }
}
