package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Email extends Page{

    WebDriver driver1;
    By eMail = By.id("email");

    public Email(WebDriver driver) {
        super(driver);
    }

     public Email typeEmail(String email){
        driver1.findElement(eMail).sendKeys(email);
        return this;
    }
}
