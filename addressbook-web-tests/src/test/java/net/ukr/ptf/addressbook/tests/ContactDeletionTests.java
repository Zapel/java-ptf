package net.ukr.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().deleteEditContact();
    }
}
