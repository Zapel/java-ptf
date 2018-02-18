package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class  GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }

}
