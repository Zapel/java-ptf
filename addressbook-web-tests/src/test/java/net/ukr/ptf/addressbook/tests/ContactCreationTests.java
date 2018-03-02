package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import net.ukr.ptf.addressbook.model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        File photo = new File("src/test/resources/28082011(001).jpg");
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new ContactData()
                .withFirstName("Oleg").withLastName("Lazeba")
                .withHomePhone("044-468-9265").withMobilePhone("063-798-8633")
                .withEmail("zapel176@ukr.net").withGroup("test1").withPhoto(photo)});
        list.add(new Object[] {new ContactData()
                .withFirstName("Oleg").withLastName("Lazeba")
                .withHomePhone("044-468-9265").withMobilePhone("063-798-8633")
                .withEmail("zapel176@ukr.net").withGroup("test1").withPhoto(photo)});
        list.add(new Object[] {new ContactData()
                .withFirstName("Oleg").withLastName("Lazeba")
                .withHomePhone("044-468-9265").withMobilePhone("063-798-8633")
                .withEmail("zapel176@ukr.net").withGroup("test1").withPhoto(photo)});
        return  list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Fisher'").withLastName("Lazeba").withHomePhone("000").withMobilePhone("111").withWorkPhone("222").withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/28082011(001).jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
