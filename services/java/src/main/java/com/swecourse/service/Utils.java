package com.swecourse.service;

import org.apache.log4j.Logger;
import com.owlike.genson.*;

public class Utils {
  /**
   *
   */
  public static void dumpObject(Logger logger, final String message, Object object) {
    logger.info(message + ": " + (new Genson()).serialize(object));
  }
  /*/
    for(Field field : contactInfo.getClass().getDeclaredFields()){
      try {
        logger.info(field.getName().toString());
        logger.info(field.get(contactInfo));
      } catch (IllegalArgumentException exc) {
        logger.error("IllegalArgumentException", exc);
      } catch (IllegalAccessException exc) {
        logger.error("IllegalAccessException", exc);
      }
    }

  /*/
}

