package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Title {

    WebDriver driver;
    WebElement title;

    public Title(WebDriver driver, By titleField) {
        this.driver = driver;
        title = driver.findElement(titleField);
    }

    public void setValue(String titlevalue){
        Select selectTitle = new Select(title);
        selectTitle.selectByValue(titlevalue);
    }
}
