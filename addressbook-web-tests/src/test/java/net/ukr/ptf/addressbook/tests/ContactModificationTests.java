package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("OlegMod", "LazebaMod", "Kiev", "zapel176@ukr.net"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

    }
}
