package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();

        //app.getContactHelper().initContactCreation();
        //app.getContactHelper().fillContactForm(new ContactData("Oleg", "Lazeba", "063-798-8633", null, "test1"), true);
        //app.getContactHelper().submitContactCreation();
        //app.getContactHelper().returnToHomePage();

        app.getContactHelper().createContact(new ContactData("Oleg", "Lazeba", "063-798-8633", null, "test1"), true);

    }
}
