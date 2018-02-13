package net.ukr.ptf.addressbook.appmanager;

import net.ukr.ptf.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactHelper {
    private ChromeDriver wd;

    public ContactHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void returnToHomePage() {
        wd.findElement(By.id("content")).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactData.getHome());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void deleteEditContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
    }

    public void editContact() {
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
    }
}
