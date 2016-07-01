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
 // сщььуте
    public static String translationPage = "C:\\Chromedriver\\TranslationMatrix.xls";

    By emailSubscription = By.xpath("//*[@id='registrationForm']/div[20]");
    By regButton = By.className("button");

    public Page(String link) {
        System.setProperty("webdriver.chrome.driver", "\\Chromedriver\\chromedriver.exe");

        //------Setting Window Size
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=420,1000");
        driver = new ChromeDriver(option);
        driver.get(link);
        WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/iframe")));
        driver.switchTo().frame(0);

        firstname = new Firstname(driver,By.id("firstname"));
        lastname = new Lastname(driver,By.id("lastname"));
        email = new Email(driver, By.id("email"));
        dateOfBirth = new Dob(driver, By.xpath("//div[@class = 'datepicker_day datepicker_field']/select"),By.xpath("//div[@class = 'datepicker_month datepicker_field']/select"), By.xpath("//div[@class = 'datepicker_year datepicker_field']/select"));
        title = new Title(driver, By.xpath("//*[@id='registrationForm']/div[5]/select"));
        country = new Country(driver,By.xpath("//*[@id='registrationForm']/div[7]/select"));
        city = new City(driver, By.id("city"));
        address = new Address(driver,By.id("address"));
        zip = new Zip(driver,By.id("zip"));
        cellphone = new Cellphone(driver,By.id("cellphone"));
        username = new Username(driver,By.id("userName"));
        password = new Password(driver,By.id("password"));
        passwordconfirm = new Passwordconfirm(driver,By.id("passwordConfirm"));
        yearsconfirm = new Yearsconfirm(driver,By.xpath("//*[@id='registrationForm']/div[19]"));
        currency = new Currency(driver, By.xpath("//*[@id='registrationForm']/div[15]/select"));
        depositlimit = new Depositlimit(driver, By.xpath("//*[@id='registrationForm']/div[16]/select"));
        depositamount = new Depositamount(driver,By.xpath("//*[@id='registrationForm']/div[17]/select"));
        bonuscode = new Bonuscode(driver, By.id("coupon"));
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