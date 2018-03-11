package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import net.ukr.ptf.addressbook.model.Contacts;
import net.ukr.ptf.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size() == 0) {
            app.goTo().homePage();
            Groups groups = app.db().groups();
            ContactData contact = new ContactData()
                    .withFirstName("Fisher").withLastName("Lazeba")
                    .withHomePhone("000").withMobilePhone("111").withWorkPhone("222")
                    .withEmail("zapel176@ukr.net")
                    .withPhoto(photo)
                    .inGroup(groups.iterator().next());
            app.contact().create(contact, true);
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(deletedContact)));
        verifyContactListInUI();
    }
}

