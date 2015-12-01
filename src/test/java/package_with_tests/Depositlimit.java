package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Depositlimit {

    WebDriver driver;
    WebElement element;

    public Depositlimit(WebDriver driver, By field) {
        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){
        Select selectTitle = new Select(element);
        selectTitle.selectByValue(value);
    }
}