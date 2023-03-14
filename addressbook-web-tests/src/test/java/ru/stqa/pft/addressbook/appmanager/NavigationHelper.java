package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    // Если та же самая страница, то остаемся на ней
    if (isElementPresent(By.name("h1"))
          && wd.findElement(By.name("h1")).getText().equals("Groups")
          && isElementPresent(By.name("new"))){
      return;
    }
    click(By.linkText("groups"));
  }

  public void gotoContactNewPage() {
    click(By.xpath("//a[contains(text(),'add new')]"));
  }

  public void homePage() {
    // Если та же самая страница, то остаемся на ней
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
}