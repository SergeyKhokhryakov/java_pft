package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String telephoneMobile;
  private String email;
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

  public ContactData() {
    this.id = Integer.MAX_VALUE;
    this.firstName = null;
    this.middleName = null;
    this.lastName = null;
    this.telephoneMobile = null;
    this.email = null;
    this.goup = null;
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

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withTelephoneMobile(String telephoneMobile) {
    this.telephoneMobile = telephoneMobile;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withGoup(String goup) {
    this.goup = goup;
    return this;
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