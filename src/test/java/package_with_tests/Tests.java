package package_with_tests;

import org.junit.After;
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
        eg.address.setValue("HJGFjgj3*");
        eg.zip.setValue("1234567890123");
        eg.cellphone.setValue("1111111");
        eg.username.setValue("HJGFjgj3*");
        eg.password.setValue("HJGFjgj3*");
        eg.passwordconfirm.setValue("HJGFjgj3*");
        eg.currency.setValue("EUR");
        eg.depositlimit.setValue("0");
        eg.bonuscode.setValue("773551");
        eg.yearsconfirm.click();
        eg.submitRegistration();

        //Assert.assertEquals(eg.firstname.errorMsgInvalid, eg.firstname.getErrorMessage());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
