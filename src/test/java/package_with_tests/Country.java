package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Country {

    WebDriver driver;
    WebElement country;

    public Country(WebDriver driver, By countryField) {
        this.driver = driver;
        country = driver.findElement(countryField);
    }

    public void setValue(String countryvalue){
        Select selectTitle = new Select(country);
        selectTitle.selectByValue(countryvalue);
    }
}
