package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationContact() {
    app.getNavigationHelper().gotoContactNewPage();
    app.getContactHelper().fillContactForm(new ContactData("Alex", "Petrovich", "Ivanov", "+7(911)123-32-77", "tower@gmail.com", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }


}
