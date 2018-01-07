package net.ukr.ptf.addressbook.appmanager;

import net.ukr.ptf.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    ChromeDriver wd;

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
        wd.get("http://localhost/addressbook/group.php");
        login("user", "pass", By.xpath("//form[@id='LoginForm']/input[3]"), "admin", "secret");
    }

    private void login(String user, String pass, By xpath, String username, String password) {
        wd.findElement(By.name(user)).click();
        wd.findElement(By.name(user)).clear();
        wd.findElement(By.name(user)).sendKeys(username);
        wd.findElement(By.name(pass)).click();
        wd.findElement(By.name(pass)).clear();
        wd.findElement(By.name(pass)).sendKeys(password);
        wd.findElement(xpath).click();
    }

    public void returnToGroupPage(String s) {
        wd.findElement(By.linkText(s)).click();
    }

    public void submitGroupCreation(String submit) {
        wd.findElement(By.name(submit)).click();
    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation(String s) {
        wd.findElement(By.name(s)).click();
    }

    public void gotoGroupPage(String groups) {
        wd.findElement(By.linkText(groups)).click();
    }

    public void stop() {
        wd.quit();
    }

    public void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}
