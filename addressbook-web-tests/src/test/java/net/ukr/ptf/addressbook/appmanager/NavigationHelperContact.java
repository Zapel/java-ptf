package net.ukr.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelperContact extends HelperBaseContact{

    public NavigationHelperContact(ChromeDriver wd) {
        super(wd);
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }
}
