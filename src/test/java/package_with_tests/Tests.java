package package_with_tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    public static String language;
    Page eg;
    @Before
    public void setUp() {
        eg = new Page(Link.lnk);
        language = "English";
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
        eg.address.setValue(Randomvalue.invalidValue(20));
        eg.zip.setValue(Randomvalue.numberValue(11)+"+");
        eg.cellphone.setValue(Randomvalue.numberValue(7));
        eg.username.setValue(Randomvalue.invalidValue(6));
        String passwordValue = Randomvalue.invalidValue(6);
        eg.password.setValue(passwordValue);
        eg.passwordconfirm.setValue(passwordValue);
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        eg.bonuscode.setValue(Randomvalue.invalidValue(7));
        eg.submitRegistration();
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
        //try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Test
    public void testEmptyData(){
        eg.submitRegistration();
        // expect, actual
        Assert.assertEquals(Parser.parseErrorMsg("Firstname","Empty"), eg.firstname.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Lastname","Empty"), eg.lastname.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Dob","Empty"), eg.dateOfBirth.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Title","Empty"), eg.title.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Email","Empty"), eg.email.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Country","Empty"), eg.country.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("City","Empty"), eg.city.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Address","Empty"), eg.address.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Zip","Empty"), eg.zip.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Cellphone","Empty"), eg.cellphone.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Username","Empty"), eg.username.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Password","Empty"), eg.password.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Passwordconfirm","Missmatch"), eg.passwordconfirm.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Depositlimit","Empty"), eg.depositlimit.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Yearsconfirm","Empty"), eg.yearsconfirm.getErrorMessage());
       //try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    @Test
    public void testValidData(){
        eg.firstname.setValue(Randomvalue.alphabetValue(6));
        eg.lastname.setValue(Randomvalue.alphabetValue(6));
        eg.dateOfBirth.setValue(Randomvalue.dob());
        eg.title.setValue(Randomvalue.title());
        eg.email.setValue(Randomvalue.email());
        eg.country.setValue(Randomvalue.country());
        eg.city.setValue(Randomvalue.alphabetValue(6));
        eg.address.setValue(Randomvalue.alphabetValue(6));
        eg.zip.setValue(Randomvalue.numberValue(12));
        eg.cellphone.setValue(Randomvalue.numberValue(7));
        eg.username.setValue(Randomvalue.alphabetValue(6));

        String passwordValue = Randomvalue.numberValue(6);
        eg.password.setValue(passwordValue);
        eg.passwordconfirm.setValue(passwordValue);
        eg.currency.setValue(Randomvalue.currency());
        String depositlimit = Randomvalue.deposit();
        eg.depositlimit.setValue(depositlimit);
        if (depositlimit != "0"){
            eg.depositamount.setValue(Randomvalue.deositamount());
        }
        eg.bonuscode.setValue(Randomvalue.numberValue(7));
        eg.yearsconfirm.click();
        eg.submitRegistration();
        //try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Test
    public void testParser(){
        System.out.println(Parser.parseErrorMsg("Firstname","Empty"));
    }
}
