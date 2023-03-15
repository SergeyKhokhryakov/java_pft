package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (! app.contact().isThereAContact()){
      app.contact().create(new ContactData()
              .withFirstName("Alex").withMiddleName("Petrovich").withLastName("Ivanov").withTelephoneMobile("+7(911)123-32-77").withEmail("tower@gmail.com").withGoup("Group1"));
    }
  }
  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.contact().all();
    int index = before.size() - 1;
    app.contact().selectContact(index);
    app.contact().deleteSelectedContact();
    app.goTo().homePage();;
    List<ContactData> after = app.contact().all();
    Assert.assertNotEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertNotEquals(after, before);

  }
}
