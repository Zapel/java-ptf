package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Oleg", null, null, null, "test1"), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactModification(before - 1);
        app.getContactHelper().fillContactForm(new ContactData("Oleg", "Lazeba", "063-798-8633", "zapel176@ukr.net", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
