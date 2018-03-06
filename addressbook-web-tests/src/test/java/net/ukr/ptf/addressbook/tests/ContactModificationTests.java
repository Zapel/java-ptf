package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import net.ukr.ptf.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size() == 0) {
            File photo = new File("src/test/resources/28082011(001).jpg");
            app.goTo().homePage();
            app.contact().create(
                    new ContactData().withFirstName("Oleg").withGroup("test1").withPhoto(photo), true);
        }
    }

    @Test
    public void testContactModification() {
        File photo = new File("src/test/resources/28082011(001).jpg");
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstName("Oleg").withLastName("Lazeba").withHomePhone("063-798-8633")
                .withEmail("zapel176@ukr.net").withPhoto(photo);
        app.goTo().homePage();
        app.contact().modify(contact);
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }
}

