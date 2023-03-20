package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation(){
    click(By.xpath("//a[contains(text(),'add new')]"));
  }
  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }
  public void initContactModification(int index) {
    wd.findElements(By.cssSelector("img[alt=\"Edit\"]")).get(index).click();
  }
  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }
  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    closeModalWindow();
  }
  public void gotoHomePage(){
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void create(ContactData contact){
    initContactCreation();
    modify(contact, true);
    submitContactCreation();
    gotoHomePage();
  }
  public void initModify(int index) {
    selectContact(index);
    initContactModification(index);
  }
  public void modify(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("mobile"), contactData.getTelephoneMobile());
    type(By.name("email"), contactData.getEmail());
    // в форме создания контакта д.б. выпадающий список групп
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      // в форме модификации контакта такого элемента не должно быть
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void shutdownModify(){
    submitContactModification();
    gotoHomePage();
  }
  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    //gotoHomePage();
  }

  public List<ContactData> all() throws Exception{
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    // блок try-catch реализован для браузера firefox
    // для остальных браузеров (chrome, edge) часть try работает стабильно
    int count = 0;
    while (count < 4) {
      try {
        for (WebElement element : elements) {
          String name = element.getText();
          String[] component = name.split(" ");
          int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
          ContactData contact = new ContactData(id, component[1], null, component[0], null, null, null);
          contacts.add(contact);
        }
        //System.out.println("Elements have been found!");
        break;
      }catch(StaleElementReferenceException | NumberFormatException sere) {
        //sere.toString();
        //System.out.println("Trying to recover from " + count + " : "+sere.getMessage());
        count=count+1;
        elements.clear();
      }
    }
    return contacts;
  }
}
