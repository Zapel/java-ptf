package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Oleg", null, null, null, "test1"), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactModification(before - 1);
        app.getContactHelper().deleteEditContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
