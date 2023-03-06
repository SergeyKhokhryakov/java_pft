package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModifiedTests extends TestBase {

  @Test
  public void testContactModified() {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Alex", "Petrovich", "Ivanov", "+7(911)123-32-77", "tower@gmail.com", "Group3"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Pauel", "Petrovich", "Tsuckalo", "+7(910)770-32-11", "tower@yandex.ru", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
