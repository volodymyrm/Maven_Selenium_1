package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Page {

    WebDriver driver;

    By address = By.id("address");
    By zip = By.id("zip");
    By cellPhone = By.id("cellphone");
    By uName = By.id("userName");
    By passWord = By.id("password");
    By passwordConfirm = By.id("passwordConfirm");
    By yearsConfirm = By.xpath("//*[@id='registrationForm']/div[19]");
    By emailSubscription = By.xpath("//*[@id='registrationForm']/div[20]");

    By regButton = By.className("button");

    By emailErrorMsg = By.xpath("//div[6]/div[@class='error_message']");
    //By fNameErrorField = By.xpath("//*[@id='registrationForm']/div[1]/div[3]");

    Firstname firstname;
    Lastname lastname;
    Email email;
    Dob dateOfBirth;
    Title title;
    Country country;
    City city;

    public Page(String link) {
        System.setProperty("webdriver.chrome.driver", "\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(link);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(0);

        firstname = firstname();
        lastname = lastname();
        email = email();
        dateOfBirth = dateOfBirth();
        title = title();
        country = country();
        city = city();
    }

    public Firstname firstname(){
        return new Firstname(driver,By.id("firstname"));
    }
    public Lastname lastname(){
        return new Lastname(driver,By.id("lastname"));
    }
    public Email email(){
        return new Email(driver, By.id("email"));
    }
    public Title title(){
        return new Title(driver, By.xpath("//*[@id='registrationForm']/div[5]/select"));
    }
    public Country country() {return new Country(driver,By.xpath("//*[@id='registrationForm']/div[7]/select")); }
    public Dob dateOfBirth(){
        return new Dob(driver, By.xpath("//div[@class = 'datepicker_day datepicker_field']/select"),By.xpath("//div[@class = 'datepicker_month datepicker_field']/select"), By.xpath("//div[@class = 'datepicker_year datepicker_field']/select"));
    }
    public City city(){return new City(driver, By.id("city")); }


    /*public String getfNameErrorField(){
        String fNameErrorField = driver.findElement(By.xpath("//*[@id='registrationForm']/div[1]/div[3]")).getText();
        return fNameErrorField;
    }*/

    public void open(String url){
        driver.get(url);
    }

    public void close(){
        driver.quit();
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