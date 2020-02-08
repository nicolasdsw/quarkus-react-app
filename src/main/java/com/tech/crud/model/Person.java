package com.tech.crud.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

  private Long id;
  private String name;
  private LocalDate birthdate;
  private Double height;
}