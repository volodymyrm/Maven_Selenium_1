package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Currency {

    WebDriver driver;
    WebElement element;

    public Currency(WebDriver driver, By field) {
        this.driver = driver;
        element = driver.findElement(field);
    }

    public void setValue(String value){
        Select selectCurrency = new Select(element);
        selectCurrency.selectByValue(value);
    }
}
