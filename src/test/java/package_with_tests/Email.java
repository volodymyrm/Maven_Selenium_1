package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Email extends Page {

    By errorMsg = By.xpath("//div[6]/div[@class='error_message']");
    By eMail = By.id("email");
    String error_invalid_characters = "Please enter a valid e-mail, using letters (a-z), numbers (0-9) and characters (._-@)";

    public Email(WebDriver driver) {
        super(driver);
    }

    public Email typeEmail(String email_value){
        driver.findElement(eMail).sendKeys(email_value);
        return this;
    }
}
