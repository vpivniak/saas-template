package com.swecourse.service.api;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class Contact {
  //
  private static final Logger logger = Logger.getLogger(Contact.class);
  //
  private static HashMap< String, Contact> contacts = new HashMap< String, Contact>();
  //
  static {
    add( new Contact("0", "John", "Doe", "john.doe@unknoen.com"));
    logger.info(contacts);
  }
  /**
   *
   */
  public Contact(final String id, final String firstName, final String secondName, final String email) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
  }
  /**
   *
   */
  public static Contact find(final String contactId) {
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
  public static Contact delete(final String contactId) {
    return contacts.remove(contactId);
  }
  /**
   *
   */
  public String getId() {
    return this.id;
  }
  public String getFirstName() {
    return this.firstName;
  }
  public String getSecondName() {
    return this.secondName;
  }
  public String getEmail() {
    return this.email;
  }

  private String id = "";
  private String firstName = "";
  private String secondName = "";
  private String email = "";
}

