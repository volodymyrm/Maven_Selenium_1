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
        eg.firstname.setValue(Randomvalue.invalidValue(6));
        eg.lastname.setValue(Randomvalue.invalidValue(6));
        eg.dateOfBirth.setValue("20", "06", "1990");
        eg.title.setValue("Mr");
        eg.email.setValue(Randomvalue.invalidValue(6));
        eg.country.setValue("GB");
        eg.city.setValue(Randomvalue.invalidValue(6));
        eg.address.setValue(Randomvalue.invalidValue(6));
        eg.zip.setValue(Randomvalue.numberValue(13));
        eg.cellphone.setValue(Randomvalue.numberValue(7));
        eg.username.setValue(Randomvalue.invalidValue(6));
        eg.password.setValue(Randomvalue.invalidValue(6));
        eg.passwordconfirm.setValue(Randomvalue.invalidValue(6));
        eg.currency.setValue("EUR");
        eg.depositlimit.setValue("0");
        eg.bonuscode.setValue(Randomvalue.numberValue(7));
        eg.yearsconfirm.click();
        eg.submitRegistration();

        Assert.assertEquals(eg.firstname.errorMsgInvalid, eg.firstname.getErrorMessage());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
