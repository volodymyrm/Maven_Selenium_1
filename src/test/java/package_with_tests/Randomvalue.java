package package_with_tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.Triple;
import java.util.Random;

public class Randomvalue {

    public static String alphabetChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public static String numberChars = "0123456789";
    public static String invalidChars = "*&?`^%+";

    public static String numberValue (int length){
        return RandomStringUtils.random(length, numberChars);
    }

    public static String alphabetValue(int length){
        return RandomStringUtils.random(length, alphabetChars);
    }

    public static String invalidValue(int length){
        if (length == 1){
            return RandomStringUtils.random(length, invalidChars);
        }
        else {
            return RandomStringUtils.random(length-1, alphabetChars)+ RandomStringUtils.random(1, invalidChars);
        }
    }
    public static String email(){
        return RandomStringUtils.random(5,alphabetChars)+"@"+RandomStringUtils.random(5,alphabetChars)+"."+"com";
    }

    public static Triple dob(){
        String[] day = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        Random rn = new Random();
        String d = day[rn.nextInt(29)];
        String m = month[rn.nextInt(11)];
        Integer x = (1940 + rn.nextInt(58));
        String y = x.toString();
        Triple<String,String,String> dob = Triple.of(d,m,y);
        return dob;
    }

    public static String country(){
        String[] country = {"GB","CZ","BS","SE","SZ","RO","PL","PT","UA","ZA","RU","DE"};
        Random rn = new Random();
        return country[rn.nextInt(11)];
    }

    public static String deposit(){
        String[] deposit = {"0","daily","weekly","monthly"};
        Random rn = new Random();
        return deposit[rn.nextInt(3)];
    }

    public static String title(){
        String[] title = {"Mr","Mrs","Ms","Miss"};
        Random rn = new Random();
        return title[rn.nextInt(3)];
    }

}
