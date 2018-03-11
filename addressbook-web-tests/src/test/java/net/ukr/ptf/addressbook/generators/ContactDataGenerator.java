package net.ukr.ptf.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import net.ukr.ptf.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target fail")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

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
        if(format.equals("csv")){
            saveAsCsv(contacts, new File(file));
        } else if(format.equals("xml")){
            saveAsXml(contacts, new File(file));
        } else if(format.equals("json")){
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format: " + format);
        }
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)) {
            for(ContactData contact : contacts) {
                writer.write(String.format("%s;%s;%s;%s\n",
                        contact.getFirstName(), contact.getLastName(),contact.getMobilePhone(), contact.getEmail()));
            }
        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(json);
        }
    }

    private List<ContactData> generateContacts(int count) {
        File photo = new File("src/test/resources/28082011(001).jpg");
        List<ContactData> contacts = new ArrayList<ContactData>();
        for(int i = 1; i < count; i ++) {
            contacts.add(new ContactData()
                    .withFirstName(String.format("FirstName%s", i)).withLastName(String.format("LastName%s", i))
<<<<<<< HEAD
                    .withHomePhone(String.format("homePhone%s", i)).withMobilePhone(String.format("mobilePhone%s", i)).withWorkPhone(String.format("workPhone%s", i))
                    .withEmail(String.format("Email_1%s", i)).withEmail2(String.format("Email_2%s", i)).withEmail3(String.format("Email_3%s", i))
=======
                    .withHomePhone(String.format("homePhone%s", i, i, i)).withMobilePhone(String.format("mobilePhone%s", i, i, i)).withWorkPhone(String.format("workPhone%s", i, i, i))
                    .withEmail("Email").withEmail2("Email2").withEmail3("Email3")
                    .withGroup(group)
>>>>>>> 420ecead3365d716492f0e0b8ca7988230644928
                    .withPhoto(photo));
        }
        return contacts;
    }
}
