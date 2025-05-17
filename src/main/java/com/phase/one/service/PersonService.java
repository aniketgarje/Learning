package com.phase.one.service;

import com.phase.one.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person savePerson(Person person);
    List<Person> getAllPerson();
    Person getPersonById(Integer id);
    boolean deletePersonById(Integer id);
}
