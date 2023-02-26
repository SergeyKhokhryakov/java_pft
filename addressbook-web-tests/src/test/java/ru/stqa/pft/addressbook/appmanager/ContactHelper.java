package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("mobile"), contactData.getTelephoneMobile());
    type(By.name("email"), contactData.getEmail());
  }
  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }
  public void returnToHomePage() {
    click(By.xpath("//a[contains(text(),'home page')]"));
  }
  public void selectContact() {
    click(By.id("1"));
  }
  public void initContactModification() {
    click(By.cssSelector("img[alt=\"Edit\"]"));
  }
  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }
}
