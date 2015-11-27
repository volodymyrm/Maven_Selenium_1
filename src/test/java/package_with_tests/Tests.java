package package_with_tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Tests {

    Page eg;
    @Before
    public void setUp() {

        eg = new Page("http://m-stg-admin.williamhillcasino.com/register2");
    }

    @After
    public void thearDown(){
        eg.close();
    }

    @Test
    public void testInvalidData(){
        //eg.typefName("HJGFjgj3*");
        //eg.typelName("HJGFjgj3*");
        //eg.setDOB("20", "06", "1990");
        //eg.setTitle("Mr");
        eg.email.typeEmail("HJGFjgj3*");
        //eg.typeEmail("HJGFjgj3*");
        //eg.setCountry("GB");
        //eg.typeCity("HJGFjgj3*");
        //eg.typeAddress("HJGFjgj3*");
        //eg.typeZip("1234567890123");
        //eg.typeCellphone("HJGFjgj3*");
        //eg.typeUname("HJGFjgj3*");
        //eg.typePassword("HJGFjgj3*");
        //eg.typeConfirmPass("HJGFjgj3*");
        //eg.setDepositLimit("0");
        //eg.submitYearsConfirm();
        //eg.submitEmailSubscription();
        //eg.submitRegistration();

        //Assert.assertEquals(eg.error_fName_invalid, eg.getfNameErrorField());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
