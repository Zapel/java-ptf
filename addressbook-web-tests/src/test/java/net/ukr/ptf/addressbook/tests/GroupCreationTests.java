package net.ukr.ptf.addressbook.tests;

import net.ukr.ptf.addressbook.model.GroupData;
import net.ukr.ptf.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class  GroupCreationTests extends TestBase {

<<<<<<< HEAD
    //@DataProvider
    //public Iterator<Object[]> validGroups() {
        //List<Object[]> list = new ArrayList<Object[]>();

        //return list.iterator();
    //}
=======
    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();

        return list.iterator();
    }
>>>>>>> 44f7e2e826fed39ca170eac5c8486d3529181e2f

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test1");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(app.group().count(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size()));
    }
}
