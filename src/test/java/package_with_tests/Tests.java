package package_with_tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {

    Page eg;
    @Before
    public void setUp() {
        eg = new Page(Link.lnk);
    }

    @After
    public void thearDown(){
        eg.close();
    }

    @Test
    public void testInvalidData(){
        eg.firstname.setValue("HJGFjgj3*");
        eg.lastname.setValue("HJGFjgj3*");
        eg.dateOfBirth.setValue("20", "06", "1990");
        eg.title.setValue("Mr");
        eg.email.setValue("HJGFjgj3*");
        eg.country.setValue("GB");
        eg.city.setValue("HJGFjgj3*");
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
        eg.submitRegistration();

        Assert.assertEquals(eg.firstname.errorMsgInvalid, eg.firstname.getErrorMessage());
        System.out.println(eg.city.getErrorMessage());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
