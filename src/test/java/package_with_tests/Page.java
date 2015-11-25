package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page {

    WebDriver driver;
    By fName = By.id("firstname");
    By lName = By.id("lastname");
    By eMail = By.id("email");
    By regButton = By.className("button");
    By city = By.id("city");
    By address = By.id("address");
    By zip = By.id("zip");
    By cellPhone = By.id("cellphone");
    By uName = By.id("userName");
    By passWord = By.id("password");
    By passwordConfirm = By.id("passwordConfirm");
    By yearsConfirm = By.xpath("//*[@id='registrationForm']/div[19]");
    By emailSubscription = By.xpath("//*[@id='registrationForm']/div[20]");
    By emailErrorMsg = By.xpath("//div[6]/div[@class='error_message']");
    //By fNameErrorField = By.xpath("//*[@id='registrationForm']/div[1]/div[3]");


    String error_empty_data = "This field is mandatory";
    String error_fName_invalid = "Please only use letters (a-z) and characters (,-.)";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getfNameErrorField(){
        String fNameErrorField = driver.findElement(By.xpath("//*[@id='registrationForm']/div[1]/div[3]")).getText();
        return fNameErrorField;
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

    public Page setDOB(String dayvalue, String monthvalue, String yearvalue){
        WebElement day = driver.findElement(By.xpath("//div[@class = 'datepicker_day datepicker_field']/select"));
        WebElement month = driver.findElement(By.xpath("//div[@class = 'datepicker_month datepicker_field']/select"));
        WebElement year = driver.findElement(By.xpath("//div[@class = 'datepicker_year datepicker_field']/select"));
        Select selectDay = new Select(day);
        Select selectMonth = new Select(month);
        Select selectYear = new Select(year);
        selectDay.selectByValue(dayvalue);
        selectMonth.selectByValue(monthvalue);
        selectYear.selectByValue(yearvalue);
        return this;
    }

    public Page setTitle(String titlevalue){
        WebElement title = driver.findElement(By.xpath("//*[@id='registrationForm']/div[5]/select"));
        Select selectTitle = new Select(title);
        selectTitle.selectByValue(titlevalue);
        return this;
    }

    public Page setCountry(String countryvalue){
        WebElement country = driver.findElement(By.xpath("//*[@id='registrationForm']/div[7]/select"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue(countryvalue);
        return this;
    }

    public Page setDepositLimit(String dopositvalue){
        WebElement deposit = driver.findElement(By.xpath("//*[@id='registrationForm']/div[16]/select"));
        Select selectCountry = new Select(deposit);
        selectCountry.selectByValue(dopositvalue);
        return this;
    }


    public Page typeEmail(String email){
        driver.findElement(eMail).sendKeys(email);
        return this;
    }

    public Page typeCity(String cityvalue){
        driver.findElement(city).sendKeys(cityvalue);
        return this;
    }

    public Page typeAddress(String addressvalue){
        driver.findElement(address).sendKeys(addressvalue);
        return this;
    }

    public Page typeZip(String zipvalue){
        driver.findElement(zip).sendKeys(zipvalue);
        return this;
    }

    public Page typeCellphone(String cellphonevalue){
        driver.findElement(cellPhone).sendKeys(cellphonevalue);
        return this;
    }

    public Page typeUname(String unamevalue){
        driver.findElement(uName).sendKeys(unamevalue);
        return this;
    }

    public Page typePassword(String passwordvalue){
        driver.findElement(passWord).sendKeys(passwordvalue);
        return this;
    }

    public Page typeConfirmPass(String confirmpassvalue){
        driver.findElement(passwordConfirm).sendKeys(confirmpassvalue);
        return this;
    }

    public Page submitYearsConfirm(){
        driver.findElement(yearsConfirm).click();
        return this;
    }

    public Page submitEmailSubscription(){
        driver.findElement(emailSubscription).click();
        return this;
    }

    public Page submitRegistration() {
        driver.findElement(regButton).click();
        return this;
    }

}