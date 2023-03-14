package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int id;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String telephoneMobile;
  private final String email;
  private String goup;

  public ContactData(int id, String firstName, String middleName, String lastName, String telephoneMobile, String email, String goup) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.telephoneMobile = telephoneMobile;
    this.email = email;
    this.goup = goup;
  }


  public ContactData(String firstName, String middleName, String lastName, String telephoneMobile, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.telephoneMobile = telephoneMobile;
    this.email = email;
    this.goup = group;
  }


  public int getId() {
    return id;
  }
  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTelephoneMobile() {
    return telephoneMobile;
  }
  public String getEmail(){
        return email;
        }

  public String getGoup() {
    return goup;
  }
  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}