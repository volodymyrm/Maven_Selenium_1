package package_with_tests;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomvalue {

    public static String alphabetChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public static String numberChars = "0123456789";
    public static String invalidChars = "*&?`^%";

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
}
