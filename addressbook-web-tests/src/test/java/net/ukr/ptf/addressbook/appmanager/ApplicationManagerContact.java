package net.ukr.ptf.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManagerContact {
    ChromeDriver wd;

    private SessionHelperContact sessionHelperContact;
    private NavigationHelperContact navigationHelperContact;
    private ContactHelper contactHelper;

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");
        contactHelper = new ContactHelper(wd);
        navigationHelperContact = new NavigationHelperContact(wd);
        sessionHelperContact = new SessionHelperContact(wd);
        sessionHelperContact.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelperContact getNavigationHelperContact() {
        return navigationHelperContact;
    }
}
