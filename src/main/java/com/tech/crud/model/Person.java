package com.tech.crud.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Person
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person extends PanacheEntity {

  @NotBlank
  public String name;
  public LocalDate birthdate;
  @Min(1)
  public Double height;
}