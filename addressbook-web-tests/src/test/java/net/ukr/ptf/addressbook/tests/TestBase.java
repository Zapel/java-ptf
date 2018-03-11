package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.appmanager.ApplicationManager;
import net.ukr.ptf.addressbook.model.ContactData;
import net.ukr.ptf.addressbook.model.Contacts;
import net.ukr.ptf.addressbook.model.GroupData;
import net.ukr.ptf.addressbook.model.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {
    File photo = new File("src/test/resources/28082011(001).jpg");
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());
    }

    public void verifyGroupListInUI() {
        if(Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData()
                    .withId(g.getId())
                    .withName(g.getName()))
                    .collect(Collectors.toSet())));
        }
    }

    public void verifyContactListInUI() {
        if(Boolean.getBoolean("verifyUI")) {
            Contacts dbContacts = app.db().contacts();
            System.out.println(dbContacts);
            Contacts uiContacts = app.contact().all();
            System.out.println(uiContacts);
            assertThat(uiContacts, equalTo(dbContacts.stream().map((c) -> new ContactData()
                    .withId(c.getId())
                    .withFirstName(c.getFirstName())
                    .withLastName(c.getLastName()))
                    .collect(Collectors.toSet())));
        }
    }
}
