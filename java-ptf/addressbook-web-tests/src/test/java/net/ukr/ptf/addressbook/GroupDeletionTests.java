package net.ukr.ptf.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
        gotoGroupPage("groups");
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage("group page");
    }
}
