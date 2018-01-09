package net.ukr.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
        app.gotoGroupPage("groups");
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage("group page");
    }
}
