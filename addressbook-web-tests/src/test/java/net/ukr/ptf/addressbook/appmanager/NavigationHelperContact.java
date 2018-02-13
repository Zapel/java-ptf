package net.ukr.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelperContact {
    private ChromeDriver wd;

    public NavigationHelperContact(ChromeDriver wd) {
        this.wd = wd;
    }

    public void gotoHomePage() {
        wd.findElement(By.linkText("home")).click();
    }
}
