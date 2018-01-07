package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage("groups");
        app.initGroupCreation("new");
        app.fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.submitGroupCreation("submit");
        app.returnToGroupPage("group page");
    }
}
