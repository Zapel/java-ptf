package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

<<<<<<< HEAD
=======
import java.util.Arrays;
import java.util.stream.Collectors;

>>>>>>> 44f7e2e826fed39ca170eac5c8486d3529181e2f
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contact().all().size() == 0) {
            app.contact().create(
                    new ContactData().withFirstName("Oleg").withMobilePhone("063-798-8633").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

<<<<<<< HEAD
        assertThat(contact.getHomePhone(), equalTo(contactInfoFromEditForm.getHomePhone()));
        assertThat(contact.getMobilePhone(), equalTo(contactInfoFromEditForm.getMobilePhone()));
        assertThat(contact.getWorkPhone(), equalTo(contactInfoFromEditForm.getWorkPhone()));
    }
=======
    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
>>>>>>> 44f7e2e826fed39ca170eac5c8486d3529181e2f
}
