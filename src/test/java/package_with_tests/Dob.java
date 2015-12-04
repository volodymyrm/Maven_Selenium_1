package package_with_tests;

import org.apache.commons.lang3.tuple.Triple;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dob {

    WebDriver driver;
    WebElement day;
    WebElement month;
    WebElement year;

    String errorMsgEmpty = "This field is mandatory";

    public Dob(WebDriver driver, By dayField, By monthField,By yearField) {
        this.driver = driver;
        day = driver.findElement(dayField);
        month = driver.findElement(monthField);
        year = driver.findElement(yearField);
    }

    public void setValue(String dayvalue, String monthvalue, String yearvalue){


        Select selectDay = new Select(day);
        Select selectMonth = new Select(month);
        Select selectYear = new Select(year);

        selectDay.selectByValue(dayvalue);
        selectMonth.selectByValue(monthvalue);
        selectYear.selectByValue(yearvalue);

    }

    public void setValue2(Triple<String,String,String> triple){

        Select selectDay = new Select(day);
        Select selectMonth = new Select(month);
        Select selectYear = new Select(year);

        selectDay.selectByValue(triple.getLeft());
        selectMonth.selectByValue(triple.getMiddle());
        selectYear.selectByValue(triple.getRight());

    }

    public String getErrorMessage(){
        return driver.findElement(By.xpath("//*[@id='registrationForm']/div[4]/div[4]")).getText();
    }
}
