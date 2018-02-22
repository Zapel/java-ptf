package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoHomePage();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(
                    new ContactData("Oleg", null, null, null, "test1"), true);
        }
    }

    @Test//(enabled = false)
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "Oleg", "Lazeba", "063-798-8633", "zapel176@ukr.net", null);
        app.getContactHelper().modifyContact(index, contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
