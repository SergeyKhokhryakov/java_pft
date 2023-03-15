package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withFirstName("Alex").withMiddleName("Petrovich").withLastName("Ivanov").withTelephoneMobile("+7(911)123-32-77").withEmail("tower@gmail.com").withGoup("Group1"));
    }
  }
  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().all();
    int index = before.size() - 1;
    app.contact().initModify(index);
    ContactData contact = new ContactData()
            .withId(before.get(index).getId()).withFirstName("Michael").withMiddleName("Stepanovich").withLastName("Pushkin").withTelephoneMobile("+7(910)770-32-11").withEmail("twitter@yandex.ru");
    app.contact().modify(contact, false);
    app.contact().shutdownModify();

    List<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }


}
