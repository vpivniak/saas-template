package com.swecourse.service.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class Contact {
  //
  private static final Logger logger = Logger.getLogger(Contact.class);
  //
  private static Integer contactNextId = 0;
  private static HashMap<Integer, Contact> contacts = new HashMap<Integer, Contact>();
  //
  static {
    add( new Contact("John", "Doe", "john.doe@unknown.com"));
  }
  /**
   *
   */
  public Contact() {
    this.id = ++contactNextId;
  }
  public Contact(final String firstName, final String lastName, final String email) {
    this.id = ++contactNextId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
  /**
   *
   */
  public static ArrayList<Contact> getAll() {
    return new ArrayList<Contact>(contacts.values());
  }
  /**
   *
   */
  public static Contact find(final Integer contactId) {
    return contacts.get(contactId);
  }
  /**
   *
   */
  public static Contact add(final Contact contact) {
    return contacts.put(contact.id, contact);
  }
  /**
   *
   */
  public static Contact delete(final Integer contactId) {
    return contacts.remove(contactId);
  }
  /**
   *
   */
  public Integer getId() {
    return this.id;
  }
  public String getFirstName() {
    return this.firstName;
  }
  public void setFirstName(final String firstName){
    this.firstName = firstName;
  }
  public String getLastName() {
    return this.lastName;
  }
  public void setLastName(final String lastName){
    this.lastName = lastName;
  }
  public String getEmail() {
    return this.email;
  }
  public void setEmail(final String email){
    this.email = email;
  }

  private Integer id = -1;
  private String firstName = "";
  private String lastName = "";
  private String email = "";
}

