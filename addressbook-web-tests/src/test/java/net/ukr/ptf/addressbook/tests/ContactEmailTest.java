package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
<<<<<<< HEAD
import net.ukr.ptf.addressbook.model.Groups;
=======
>>>>>>> 420ecead3365d716492f0e0b8ca7988230644928
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size() == 0) {
            app.goTo().homePage();
<<<<<<< HEAD
            Groups groups = app.db().groups();
            ContactData contact = new ContactData()
                    .withFirstName("Fisher")
                    .withHomePhone("000").withMobilePhone("111")
                    .withEmail("zapel176@ukr.net")
                    .withPhoto(photo)
                    .inGroup(groups.iterator().next());
            app.contact().create(contact, true);
=======
            app.contact().create(
                    new ContactData()
                            .withFirstName("Oleg").withLastName("Lazeba")
                            .withHomePhone("111").withMobilePhone("063-798-8633").withWorkPhone("222")
                            .withEmail("eMail").withEmail2("222").withEmail3("333")
                            .withGroup("test1")
                            .withPhoto(photo), true);
>>>>>>> 420ecead3365d716492f0e0b8ca7988230644928
        }
    }

    @Test
    public void testContactEmails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactEmailTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[()]", "");
    }

}
