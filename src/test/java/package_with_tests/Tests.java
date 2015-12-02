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
        //eg.dateOfBirth.setValue("20", "06", "1990");
        //eg.title.setValue("Mr");
        eg.email.setValue(Randomvalue.invalidValue(6));
        //eg.country.setValue("GB");
        eg.city.setValue(Randomvalue.invalidValue(6));
        eg.address.setValue(Randomvalue.invalidValue(6));
        //eg.zip.setValue(Randomvalue.numberValue(13));
        eg.cellphone.setValue(Randomvalue.numberValue(7));
        eg.username.setValue(Randomvalue.invalidValue(6));

        String passwordValue = Randomvalue.invalidValue(6);
        eg.password.setValue(passwordValue);
        eg.passwordconfirm.setValue(passwordValue);
        //eg.currency.setValue("EUR");
        //eg.depositlimit.setValue("0");
        eg.bonuscode.setValue(Randomvalue.numberValue(7));
        eg.yearsconfirm.click();
        eg.submitRegistration();

        Assert.assertEquals(eg.firstname.errorMsgInvalid, eg.firstname.getErrorMessage());
        Assert.assertEquals(eg.lastname.errorMsgInvalid, eg.lastname.getErrorMessage());
        Assert.assertEquals(eg.email.errorMsgInvalid, eg.email.getErrorMessage());
        Assert.assertEquals(eg.city.errorMsgInvalid, eg.city.getErrorMessage());
        Assert.assertEquals(eg.address.errorMsgInvalid, eg.address.getErrorMessage());
        Assert.assertEquals(eg.cellphone.errorMsgInvalid, eg.cellphone.getErrorMessage());
        Assert.assertEquals(eg.username.errorMsgInvalid, eg.username.getErrorMessage());
        Assert.assertEquals(eg.password.errorMsgInvalid, eg.password.getErrorMessage());
        Assert.assertEquals(eg.passwordconfirm.errorMsgInvalid, eg.passwordconfirm.getErrorMessage());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testEmptyData(){
        eg.submitRegistration();

        Assert.assertEquals(eg.firstname.getErrorMessage(), eg.firstname.errorMsgEmpty);

    }

}
