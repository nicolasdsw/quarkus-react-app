package com.tech.crud.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.tech.crud.model.Person;

@ApplicationScoped
public class PersonService {

  @Transactional
  public Person create(Person dto) {
    Person person = new Person();
    person.name = dto.name;
    person.birthdate = dto.birthdate;
    person.height = dto.height;
    person.persist();
    return person;
  }

  @Transactional
  public Person update(Long id, Person dto) {
    Person person = Person.findById(id);
    if (person == null)
      throw new WebApplicationException("person not found", Status.EXPECTATION_FAILED);
    person.name = dto.name;
    person.birthdate = dto.birthdate;
    person.height = dto.height;
    return person;
  }

  @Transactional
  public void delete(Long id) {
    Person person = Person.findById(id);
    if (person == null)
      throw new WebApplicationException("person not found", Status.EXPECTATION_FAILED);
    person.delete();
  }

  public List<Person> findAll() {
    return Person.listAll();
  }

  public Optional<Person> findById(Long id) {
    return Person.findByIdOptional(id);
  }
}