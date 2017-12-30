package com.swecourse.service.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.swecourse.service.api.ContactInfo;

public class Contacts {
  //
  private static final Logger logger = Logger.getLogger(Contact.class);
  //
  static public class Contact {

    public Contact(final Integer id, final ContactInfo info){
      this.id = id;
      this.info = info;
      this.refs.put("get", "http://host:port/api/v1/contacts/" + this.id);
      this.refs.put("put", "http://host:port/api/v1/contacts/" + this.id);
      this.refs.put("patch", "http://host:port/api/v1/contacts/" + this.id);
      this.refs.put("delete", "http://host:port/api/v1/contacts/" + this.id);
    }
    public Integer getId() { return this.id; }
    public ContactInfo getInfo() { return this.info; }
    public ContactInfo setInfo(final ContactInfo contactInfo) { ContactInfo info = this.info; this.info = contactInfo; return info; }
    public HashMap<String, String> getRefs() { return this.refs; }


    private Integer id = -1;
    private ContactInfo info = null;
    private HashMap<String, String> refs = new HashMap<String, String>();
  }
  //
  private static Integer contactNextId = 0;
  private static HashMap<Integer, Contact> contacts = new HashMap<Integer, Contact>();
  //
  static {
    add( new ContactInfo("John", "Doe", "john.doe@unknown.com"));
  }
  /**
   *
   */
  public Contacts() {
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
  public static Contact add(final ContactInfo contactInfo) {
    final Integer newId = ++contactNextId;
    Contact c = new Contact(newId, contactInfo);
    contacts.put(newId, c);
    return c;
  }
  /**
   *
   */
  public static Contact update(final Integer contactId, final ContactInfo contactInfo) {
    Contact c = contacts.get(contactId);
    if (c != null){
      c.setInfo(contactInfo);
      contacts.put(c.getId(), c);
    }
    return c;
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

