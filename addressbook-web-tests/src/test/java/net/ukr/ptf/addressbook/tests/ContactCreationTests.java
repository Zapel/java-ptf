package net.ukr.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBaseContact {

    @Test
    public void testContactCreation() {
        gotoHomePage();
        initContactCreation();
        fillContactForm(new ContactData("Oleg", "Lazeba", "Kiev", "zapel176@ukr.net"));
        submitContactCreation();
        returnToHomePage();
    }

}
