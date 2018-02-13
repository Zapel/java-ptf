package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBaseContact {

    @Test
    public void testContactCreation() {
        appCont.gotoHomePage();
        appCont.initContactCreation();
        appCont.fillContactForm(new ContactData("Oleg", "Lazeba", "Kiev", "zapel176@ukr.net"));
        appCont.submitContactCreation();
        appCont.returnToHomePage();
    }

}
