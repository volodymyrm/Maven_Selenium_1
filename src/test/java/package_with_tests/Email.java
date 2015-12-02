package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Email {

    WebDriver driver;
    WebElement email;

    String errorMsgEmpty = "This field is mandatory";
    String errorMsgInvalid ="Please enter a valid e-mail, using letters (a-z), numbers (0-9) and characters (._-@)";

    public Email(WebDriver driver, By emailField) {
        this.driver = driver;
        email = driver.findElement(emailField);
    }

     public void setValue(String emailvalue){
         email.sendKeys(emailvalue);
    }

    public String getErrorMessage(){
        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[6]/div[3]")).getText();
    }
}
