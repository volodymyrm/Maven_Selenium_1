package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page {

    protected WebDriver driver;
    By fName = By.id("firstname");
    By lName = By.id("lastname");
    By eMail = By.id("email");
   // By  = By.xpath("//div[@class = 'datepicker_day datepicker_field']");

   // WebElement dayField = driver.findElement(By.xpath("//div[@class = 'datepicker_day datepicker_field']"));
    //Select select = new Select(dayField);

    By regButton = By.className("button");

    By emailErrorMsg = By.xpath("//div[6]/div[@class='error_message']");

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

    public Page typeEmail(String email){
        driver.findElement(eMail).sendKeys(email);
        return this;
    }
/*
    public Page setDOB(String day){
        select.selectByValue(day);
        return this;
    }*/

    public Page submitRegistration() {
        driver.findElement(regButton).click();
        return this;
    }

}