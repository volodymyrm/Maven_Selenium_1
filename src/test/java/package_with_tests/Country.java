package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Country {

    WebDriver driver;
    WebElement element;

    String errorMsgEmpty = "This field is mandatory";

    public Country(WebDriver driver, By field) {
        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){
        Select selectCountry = new Select(element);
        selectCountry.selectByValue(value);
    }

    public String getErrorMessage(){
        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[7]/div[3]")).getText();
    }
}
