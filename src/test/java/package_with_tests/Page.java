package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Page {

    By fName = By.id("firstname");
    By lName = By.id("lastname");
    By regButton = By.className("button");

    private final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
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
        driver.findElement(regButton).sendKeys(Keys.ARROW_DOWN);
        return this;
    }

}