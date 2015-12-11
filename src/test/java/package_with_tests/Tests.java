package package_with_tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    public static String language;
    Page wh;
    @Before
    public void setUp() {
        // -----------------------------------INPUT HERE LINK OF THE PAGE THAT WILL BE TESTED
        wh = new Page(Link.lnk);

        // -----------------------------------INPUT HERE LANGUAGE OF THE PAGE
        language = "English";
    }

    @After
    public void thearDown(){
        wh.close();
        //int a=0;
    }

    @Test
    public void testInvalidData(){
        wh.firstname.setValue(Randomvalue.invalidValue(6));
        wh.lastname.setValue(Randomvalue.invalidValue(6));
        wh.email.setValue(Randomvalue.invalidValue(6));
        wh.city.setValue(Randomvalue.invalidValue(6));
        wh.address.setValue(Randomvalue.invalidValue(20));
        wh.zip.setValue(Randomvalue.numberValue(11)+"+");
        wh.username.setValue(Randomvalue.invalidValue(6));
        String passwordValue = Randomvalue.invalidValue(6);
        wh.password.setValue(passwordValue);
        wh.passwordconfirm.setValue(passwordValue);
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        wh.bonuscode.setValue(Randomvalue.invalidValue(7));
        wh.submitRegistration();
        // expect, actual
        Assert.assertEquals(Parser.parseErrorMsg("Firstname","InvalidData"), wh.firstname.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Lastname","InvalidData"), wh.lastname.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Email","InvalidData"), wh.email.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("City","InvalidData"), wh.city.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Address","InvalidData"), wh.address.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Zip","InvalidData"), wh.zip.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Username","InvalidData"), wh.username.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Password","InvalidData"), wh.password.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Passwordconfirm","InvalidData"), wh.passwordconfirm.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Bonuscode","InvalidData"), wh.bonuscode.getErrorMessage());
        //try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Test
    public void testLongData(){
        wh.firstname.setValue(Randomvalue.alphabetValue(51));
        wh.lastname.setValue(Randomvalue.alphabetValue(51));
        wh.cellphone.setValue(Randomvalue.numberValue(21));
        wh.address.setValue(Randomvalue.alphabetValue(161));
        wh.submitRegistration();
        // expect, actual
        Assert.assertEquals(Parser.parseErrorMsg("Firstname","InvalidLength"), wh.firstname.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Lastname","InvalidLength"), wh.lastname.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Cellphone","InvalidLength"), wh.cellphone.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Address", "InvalidLength"), wh.address.getErrorMessage());
    }

    @Test
    public void testEmptyData(){
        wh.submitRegistration();
        // expect, actual
        Assert.assertEquals(Parser.parseErrorMsg("Firstname","Empty"), wh.firstname.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Lastname","Empty"), wh.lastname.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Dob","Empty"), wh.dateOfBirth.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Title","Empty"), wh.title.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Email","Empty"), wh.email.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Country","Empty"), wh.country.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("City","Empty"), wh.city.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Address","Empty"), wh.address.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Zip","Empty"), wh.zip.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Cellphone","Empty"), wh.cellphone.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Username","Empty"), wh.username.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Password","Empty"), wh.password.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Passwordconfirm","Missmatch"), wh.passwordconfirm.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Depositlimit","Empty"), wh.depositlimit.getErrorMessage());
        Assert.assertEquals(Parser.parseErrorMsg("Yearsconfirm","Empty"), wh.yearsconfirm.getErrorMessage());
       //try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Test
    public void testValidData(){
        wh.firstname.setValue(Randomvalue.alphabetValue(6));
        wh.lastname.setValue(Randomvalue.alphabetValue(6));
        wh.dateOfBirth.setValue(Randomvalue.dob());
        wh.title.setValue(Randomvalue.title());
        wh.email.setValue(Randomvalue.email());
        wh.country.setValue(Randomvalue.country());
        wh.city.setValue(Randomvalue.alphabetValue(6));
        wh.address.setValue(Randomvalue.alphabetValue(6));
        wh.zip.setValue(Randomvalue.numberValue(12));
        wh.cellphone.setValue(Randomvalue.numberValue(7));
        wh.username.setValue(Randomvalue.alphabetValue(6));

        String passwordValue = Randomvalue.numberValue(6);
        wh.password.setValue(passwordValue);
        wh.passwordconfirm.setValue(passwordValue);
        wh.currency.setValue(Randomvalue.currency());
        String depositlimit = Randomvalue.deposit();
        wh.depositlimit.setValue(depositlimit);
        if (depositlimit != "0"){
            wh.depositamount.setValue(Randomvalue.deositamount());
        }
        wh.bonuscode.setValue(Randomvalue.numberValue(7));
        wh.yearsconfirm.click();
        wh.submitRegistration();
        //try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    /*@Test
    public void testParser(){
        System.out.println(Parser.parseErrorMsg("Dob","Empty"));
    }*/

}
