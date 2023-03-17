package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationContact() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Alexandr").withMiddleName("Petrovich").withLastName("Ivanov").withTelephoneMobile("+7(911)123-32-77").withEmail("tower@gmail.com").withGoup("Group1");
    app.contact().create(contact);

    List<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }


}
