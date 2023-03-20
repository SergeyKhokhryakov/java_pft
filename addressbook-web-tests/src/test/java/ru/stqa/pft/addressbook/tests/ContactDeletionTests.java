package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws Exception {
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withFirstName("Alex").withMiddleName("Petrovich").withLastName("Ivanov").withTelephoneMobile("+7(911)123-32-77").withEmail("tower@gmail.com").withGoup("Group1"));
    }
  }
  @Test(groups = {"positive", "contact"}, priority = 3)
  public void testContactDeletion() throws Exception {
    List<ContactData> before = app.contact().all();
    int index = before.size() - 1;
    app.contact().delete(index);

    List<ContactData> after = app.contact().all();
    Assert.assertNotEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertNotEquals(after, before);
  }


}
