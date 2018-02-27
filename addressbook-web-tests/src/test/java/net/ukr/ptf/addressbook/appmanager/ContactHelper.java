package net.ukr.ptf.addressbook.appmanager;

import net.ukr.ptf.addressbook.model.ContactData;
import net.ukr.ptf.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.id("content"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        attach(By.name("photo"), contactData.getPhoto());

        if(creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void deleteEditContact() {
        click(xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void initContactModificationById(int id) {
        //wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        initContactModificationById(contact.getId());
        deleteEditContact();
        contactCache = null;
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.cssSelector("img[alt='Edit']"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if(contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element : elements) {
            List<WebElement> cells = element.findElements(tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
                    .withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
