package net.ukr.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBaseContact {
    
    @Test
    public void testContactDeletion() {
        appCont.gotoHomePage();
        appCont.editContact();
        appCont.deleteEditContact();
    }
}
