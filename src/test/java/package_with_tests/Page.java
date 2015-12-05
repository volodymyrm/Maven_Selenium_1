package package_with_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    WebDriver driver;
    Firstname firstname;
    Lastname lastname;
    Email email;
    Dob dateOfBirth;
    Title title;
    Country country;
    City city;
    Address address;
    Zip zip;
    Cellphone cellphone;
    Username username;
    Password password;
    Passwordconfirm passwordconfirm;
    Currency currency;
    Depositlimit depositlimit;
    Depositamount depositamount;
    Bonuscode bonuscode;
    Yearsconfirm yearsconfirm;

    By emailSubscription = By.xpath("//*[@id='registrationForm']/div[20]");
    By regButton = By.className("button");

    public Page(String link) {
        System.setProperty("webdriver.chrome.driver", "\\Chromedriver\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=420,1000");
        driver = new ChromeDriver(option);
        driver.get(link);
        WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/iframe")));
        driver.switchTo().frame(0);

        firstname = firstname();
        lastname = lastname();
        email = email();
        dateOfBirth = dateOfBirth();
        title = title();
        country = country();
        city = city();
        address = address();
        zip = zip();
        cellphone = cellphone();
        username = username();
        password = password();
        passwordconfirm = passwordconfirm();
        yearsconfirm = yearsconfirm();
        currency = currency();
        depositlimit = depositlimit();
        depositamount = depositamount();
        bonuscode = bonuscode();
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
    public Country country() {
        return new Country(driver,By.xpath("//*[@id='registrationForm']/div[7]/select"));
    }
    public Dob dateOfBirth(){
        return new Dob(driver, By.xpath("//div[@class = 'datepicker_day datepicker_field']/select"),By.xpath("//div[@class = 'datepicker_month datepicker_field']/select"), By.xpath("//div[@class = 'datepicker_year datepicker_field']/select"));
    }
    public City city(){

        return new City(driver, By.id("city"));
    }
    public Address address(){
        return new Address(driver,By.id("address"));
    }
    public Zip zip(){
        return new Zip(driver,By.id("zip"));
    }
    public Cellphone cellphone(){
        return new Cellphone(driver,By.id("cellphone"));
    }
    public Username username(){
        return new Username(driver,By.id("userName"));
    }
    public Password password(){
        return new Password(driver,By.id("password"));
    }
    public Passwordconfirm passwordconfirm(){
        return new Passwordconfirm(driver,By.id("passwordConfirm"));
    }
    public Currency currency(){
        return new Currency(driver, By.xpath("//*[@id='registrationForm']/div[15]/select"));
    }
    public Yearsconfirm yearsconfirm(){
        return new Yearsconfirm(driver,By.xpath("//*[@id='registrationForm']/div[19]"));
    }
    public Depositlimit depositlimit(){
        return new Depositlimit(driver, By.xpath("//*[@id='registrationForm']/div[16]/select"));
    }
    public Depositamount depositamount(){
        return new Depositamount(driver,By.xpath("//*[@id='registrationForm']/div[17]/select"));
    }
    public Bonuscode bonuscode(){
        return new Bonuscode(driver, By.id("coupon"));
    }
    public void close(){
        driver.quit();
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