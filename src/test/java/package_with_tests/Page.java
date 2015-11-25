package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page {

    protected WebDriver driver;
    By fName = By.id("firstname");
    By lName = By.id("lastname");
    By eMail = By.id("email");

   /* WebElement day = driver.findElement(By.xpath("//div[@class = 'datepicker_day datepicker_field']/select"));
    Select selectDay = new Select(day);*/

    By regButton = By.className("button");

    By emailErrorMsg = By.xpath("//div[6]/div[@class='error_message']");

    public Page(WebDriver driver) {
        this.driver = driver;
    }

 /*   public Page setDOB(String dayvalue){
        selectDay.selectByValue(dayvalue);
        return this;
    }*/

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


    public Page submitRegistration() {
        driver.findElement(regButton).click();
        return this;
    }

}