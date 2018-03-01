package net.ukr.ptf.addressbook.generators;

<<<<<<< HEAD
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
=======
>>>>>>> 44f7e2e826fed39ca170eac5c8486d3529181e2f
import net.ukr.ptf.addressbook.model.ContactData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

<<<<<<< HEAD
    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target fail")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        save (contacts, new File(file));
    }

    private void save(List<ContactData> contacts, File file) throws IOException {
=======
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save (contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
>>>>>>> 44f7e2e826fed39ca170eac5c8486d3529181e2f
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for(ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s\n",
                    contact.getFirstName(), contact.getLastName(),contact.getMobilePhone(), contact.getEmail()));
        }
        writer.close();
    }

<<<<<<< HEAD
    private List<ContactData> generateContacts(int count) {
=======
    private static List<ContactData> generateContacts(int count) {
>>>>>>> 44f7e2e826fed39ca170eac5c8486d3529181e2f
        List<ContactData> contacts = new ArrayList<ContactData>();
        for(int i = 0; i < count; i ++) {
            contacts.add(new ContactData().withFirstName(String.format("FirstName%s", i))
                    .withLastName(String.format("LastName%s", i))
                    .withMobilePhone(String.format("%s%s%s", i, i, i))
                    .withEmail(String.format("Email%s", i)));
        }
        return contacts;
    }
}
