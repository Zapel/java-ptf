package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.appmanager.ApplicationManagerContact;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseContact {

    protected final ApplicationManagerContact appCont = new ApplicationManagerContact();

    @BeforeMethod
    public void setUp() throws Exception {
        appCont.init();
    }

    @AfterMethod
    public void tearDown() {
        appCont.stop();
    }

}
