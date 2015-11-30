package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class City {

    WebDriver driver;
    WebElement city;

    public City(WebDriver driver, By cityfield){

        this.driver = driver;
        city = driver.findElement(cityfield);
    }

    public void setValue(String cityvalue){

        city.sendKeys(cityvalue);
    }
    public String getErrorMessage(){
        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[8]/div[3]")).getText();
    }
}
