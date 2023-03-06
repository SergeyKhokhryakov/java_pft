package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Alex", "Petrovich", "Ivanov", "+7(911)123-32-77", "tower@gmail.com", "Group3"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHomePage();
  }
}
