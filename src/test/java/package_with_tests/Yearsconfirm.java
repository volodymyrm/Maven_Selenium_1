package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Yearsconfirm {

    WebDriver driver;
    WebElement element;

    public Yearsconfirm(WebDriver driver, By field){

        this.driver = driver;
        element = driver.findElement(field);
    }

    public void click(){

        element.click();
    }

    public String getErrorMessage(){

        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[19]/div[3]")).getText();
    }
}
