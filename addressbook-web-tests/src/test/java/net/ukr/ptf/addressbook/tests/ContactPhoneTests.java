package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import net.ukr.ptf.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size() == 0) {
            app.goTo().homePage();
<<<<<<< HEAD
            Groups groups = app.db().groups();
            ContactData contact = new ContactData()
                    .withFirstName("Fisher").withLastName("Lazeba")
                    .withHomePhone("000")
                    .withEmail("zapel176@ukr.net")
                    .withPhoto(photo)
                    .inGroup(groups.iterator().next());
            app.contact().create(contact, true);
=======
            app.contact().create(
                    new ContactData()
                            .withFirstName("Oleg").withLastName("Lazeba")
                            .withHomePhone("111").withMobilePhone("063-798-8633").withWorkPhone("222")
                            .withEmail("eMail").withEmail2("eMail2").withEmail3("eMail2")
                            .withGroup("test1")
                            .withPhoto(photo), true);
>>>>>>> 420ecead3365d716492f0e0b8ca7988230644928
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
