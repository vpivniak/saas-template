package com.swecourse.service.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class ContactInfo {
  //
  private static final Logger logger = Logger.getLogger(ContactInfo.class);
  /**
   *
   */
  public ContactInfo() {
  }
  public ContactInfo(final String firstName, final String lastName, final String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
  /**
   *
   */
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

  private String firstName = "";
  private String lastName = "";
  private String email = "";
}

