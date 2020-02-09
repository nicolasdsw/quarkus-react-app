package com.tech.crud.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tech.crud.model.Person;
import com.tech.crud.service.PersonService;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "persons", description = "Operations on persons resource.")
public class PersonController {

  @Inject
  PersonService service;

  @GET
  @Operation(summary = "Get all persons")
  public List<Person> index() {
    return this.service.findAll();
  }

  @GET
  @Path("{id}")
  @APIResponse(responseCode = "200")
  @APIResponse(responseCode = "404", description = "person not found")
  @Operation(summary = "Find person by ID")
  public Person show(@PathParam("id") Long id) {
    return this.service.findById(id)
        .orElseThrow(() -> new WebApplicationException("person not found", Status.EXPECTATION_FAILED));
  }

  @POST
  @APIResponse(responseCode = "201", description = "person created")
  @APIResponse(responseCode = "406", description = "Invalid data")
  @Operation(summary = "Create new resource")
  public Response create(@Valid Person dto) {
    return Response.ok(this.service.create(dto)).status(Status.CREATED).build();
  }

  @PUT
  @Path("{id}")
  @APIResponse(responseCode = "200")
  @APIResponse(responseCode = "404", description = "person not found")
  @Operation(summary = "Edit person by ID")
  public Person update(@PathParam("id") Long id, @Valid Person dto) {
    return this.service.update(id, dto);
  }

  @DELETE
  @Path("{id}")
  @APIResponse(responseCode = "204", description = "person deleted")
  @APIResponse(responseCode = "404", description = "person not found")
  @Operation(summary = "Delete person by ID")
  public Response delete(@PathParam("id") Long id) {
    this.service.delete(id);
    return Response.status(Status.NO_CONTENT).build();
  }
}