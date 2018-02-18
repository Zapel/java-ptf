package net.ukr.ptf.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String home;
    private final String email;
    private String group;

    public ContactData(String firstName, String lastName, String home, String email, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.home = home;
        this.email = email;
        this.group = group;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHome() {
        return home;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
