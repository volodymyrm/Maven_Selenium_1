package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Page {

    protected WebDriver driver;
    By fName = By.id("firstname");
    By lName = By.id("lastname");
    By regButton = By.className("button");

    public Page(WebDriver driver) {
        this.driver = driver;
    }
    public void open(String url){
        driver.get(url);
    }

    public void close(){
        driver.quit();
    }

    public void switchToFrame(){
        driver.switchTo().frame(0);
    }

    public Page typefName(String fname){
        driver.findElement(fName).sendKeys(fname);
        return this;
    }

    public Page typelName(String fname){
        driver.findElement(lName).sendKeys(fname);
        return this;
    }

    public Page submitRegistration() {
        driver.findElement(regButton).click();
        return this;
    }

}