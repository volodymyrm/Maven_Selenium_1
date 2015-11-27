package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Lastname {

    WebDriver driver;
    WebElement lastname;

    public Lastname(WebDriver driver, By lastnameField) {
        this.driver = driver;
        lastname = driver.findElement(lastnameField);
    }

    public void setValue(String larstnameValue){
        lastname.sendKeys(larstnameValue);
    }

    public String getErrorMessage(){
        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[2]/div[3]")).getText();
    }
}
