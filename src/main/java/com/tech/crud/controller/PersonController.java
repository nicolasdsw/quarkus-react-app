package com.tech.crud.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tech.model.Person;

@Path("/api/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonController {

    @GET
    public List<Person> index() {
        return Arrays.asList(Person.builder().id(1L).name("Jackie Tequila").birthdate(LocalDate.of(1990, 10, 02)).height(1.75).build());
    }
}