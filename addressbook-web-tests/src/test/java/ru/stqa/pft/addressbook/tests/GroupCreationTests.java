package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("Group2", null, null);
    app.getGroupHelper().createGroup(group);
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    /* Вариант 1
    int max = 0;
    for (GroupData g : after){
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    */
    /* Вариант 2
    Comparator<? super GroupData> byId = new Comparator<GroupData>() {
      @Override
      public int compare(GroupData o1, GroupData o2) {
        return Integer.compare(o1.getId(), o2.getId());
      }
    };
    int max1 = after.stream().max(byId).get().getId();
     */
    // Вариант 3
    // Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    /* Вариант 4
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    int max1 = after.stream().max(byId).get().getId();
    group.setId(max1);
     */
    /* Сравнение неупорядоченных множеств
    group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
     */

    // Сравнение упорядоченных списков, когда уникальными идентификаторами можно пренебречь
    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
