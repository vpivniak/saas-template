package com.swecourse.service.api.v1;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.PathSegment;

import org.apache.log4j.Logger;

import com.swecourse.service.ApiResponse;
import com.swecourse.service.api.Contact;

/**
 * 
 */
@Path("api/v1/contacts")
public class ContactsResource {

  private static final Logger logger = Logger.getLogger(ContactsResource.class);


  /**
   * Create contact
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateVacanciesByCompaniesAndDate(@Context UriInfo uriInfo) {
    logger.info(uriInfo.getRequestUri());

    List<Object> objList = new ArrayList<>();
    objList.add("Random String");
    objList.add(121); //int
    objList.add(1.22); //double
    objList.add(false); //boolean
    return Response.status(Response.Status.CREATED).entity(ApiResponse.build(objList)).build();
  }

  /**
   */
  @GET
  @Path("/{contactId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getContactById(@Context UriInfo uriInfo, @PathParam("contactId") String contactId) {
    logger.info(uriInfo.getRequestUri());
    Contact contact = Contact.find(contactId);
    if (contact != null) {
      return Response.ok().entity(ApiResponse.build(contact)).build();
    }
    return Response.status(Response.Status.NOT_FOUND).build();
  }

  /**
   */
  @DELETE
  @Path("/{contactId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteContactById(@Context UriInfo uriInfo, @PathParam("contactId") String contactId) {
    logger.info(uriInfo.getRequestUri());
    Contact contact = Contact.delete(contactId);
    if (contact != null) {
      return Response.ok().entity(ApiResponse.build(contact)).build();
    }
    return Response.status(Response.Status.NOT_FOUND).build();
  }

}
