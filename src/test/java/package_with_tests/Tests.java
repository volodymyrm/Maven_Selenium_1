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
        eg.email.setValue(Randomvalue.invalidValue(6));
        eg.city.setValue(Randomvalue.invalidValue(6));
        eg.address.setValue(Randomvalue.invalidValue(6));
        eg.zip.setValue(Randomvalue.numberValue(13)+"+");
        eg.cellphone.setValue(Randomvalue.numberValue(7));
        eg.username.setValue(Randomvalue.invalidValue(6));

        String passwordValue = Randomvalue.invalidValue(6);
        eg.password.setValue(passwordValue);
        eg.passwordconfirm.setValue(passwordValue);
        eg.bonuscode.setValue(Randomvalue.invalidValue(7));
        eg.submitRegistration();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        // expect, actual
        Assert.assertEquals(eg.firstname.errorMsgInvalid, eg.firstname.getErrorMessage());
        Assert.assertEquals(eg.lastname.errorMsgInvalid, eg.lastname.getErrorMessage());
        Assert.assertEquals(eg.email.errorMsgInvalid, eg.email.getErrorMessage());
        Assert.assertEquals(eg.city.errorMsgInvalid, eg.city.getErrorMessage());
        Assert.assertEquals(eg.address.errorMsgInvalid, eg.address.getErrorMessage());
        Assert.assertEquals(eg.zip.errorMsgInvalid, eg.zip.getErrorMessage());
        Assert.assertEquals(eg.cellphone.errorMsgInvalid, eg.cellphone.getErrorMessage());
        Assert.assertEquals(eg.username.errorMsgInvalid, eg.username.getErrorMessage());
        Assert.assertEquals(eg.password.errorMsgInvalid, eg.password.getErrorMessage());
        Assert.assertEquals(eg.passwordconfirm.errorMsgInvalid, eg.passwordconfirm.getErrorMessage());
        Assert.assertEquals(eg.bonuscode.errorMsgInvalid, eg.bonuscode.getErrorMessage());

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    @Test
    public void testEmptyData(){
        eg.submitRegistration();

        // expect, actual
        Assert.assertEquals(eg.firstname.errorMsgEmpty, eg.firstname.getErrorMessage());
        Assert.assertEquals(eg.lastname.errorMsgEmpty, eg.lastname.getErrorMessage());
        Assert.assertEquals(eg.dateOfBirth.errorMsgEmpty, eg.dateOfBirth.getErrorMessage());
        Assert.assertEquals(eg.title.errorMsgEmpty, eg.title.getErrorMessage());
        Assert.assertEquals(eg.email.errorMsgEmpty, eg.email.getErrorMessage());
        Assert.assertEquals(eg.country.errorMsgEmpty, eg.country.getErrorMessage());
        Assert.assertEquals(eg.city.errorMsgEmpty, eg.city.getErrorMessage());
        Assert.assertEquals(eg.address.errorMsgEmpty, eg.address.getErrorMessage());
        Assert.assertEquals(eg.zip.errorMsgEmpty, eg.zip.getErrorMessage());
        Assert.assertEquals(eg.cellphone.errorMsgEmpty, eg.cellphone.getErrorMessage());
        Assert.assertEquals(eg.username.errorMsgEmpty, eg.username.getErrorMessage());
        Assert.assertEquals(eg.password.errorMsgEmpty, eg.password.getErrorMessage());
        Assert.assertEquals(eg.passwordconfirm.errorMsgPassMissmatch, eg.passwordconfirm.getErrorMessage());
        Assert.assertEquals(eg.depositlimit.errorMsgEmpty, eg.depositlimit.getErrorMessage());
        Assert.assertEquals(eg.yearsconfirm.errorMsgEmpty, eg.yearsconfirm.getErrorMessage());
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

    }
    @Test
    public void testValidData(){
        eg.firstname.setValue(Randomvalue.alphabetValue(6));
        eg.lastname.setValue(Randomvalue.alphabetValue(6));
        eg.dateOfBirth.setValue(Randomvalue.dob());
        eg.title.setValue(Randomvalue.title());
        eg.email.setValue(Randomvalue.invalidValue(6));
        eg.country.setValue(Randomvalue.country());
        eg.city.setValue(Randomvalue.invalidValue(6));
        eg.address.setValue(Randomvalue.invalidValue(6));
        eg.zip.setValue(Randomvalue.numberValue(13));
        eg.cellphone.setValue(Randomvalue.numberValue(7));
        eg.username.setValue(Randomvalue.invalidValue(6));

        String passwordValue = Randomvalue.invalidValue(6);
        eg.password.setValue(passwordValue);
        eg.passwordconfirm.setValue(passwordValue);
        //eg.currency.setValue("EUR");
        eg.depositlimit.setValue("0");
        eg.bonuscode.setValue(Randomvalue.numberValue(7));
        eg.yearsconfirm.click();
        eg.submitRegistration();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

}
