package com.phase.one.controller;


import com.phase.one.model.Person;
import com.phase.one.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    /*
    Note - Change port number as per your configuration of application
         - I have used MySQL Database in this project

    http://localhost:8081/api/all      - get all data from database
    http://localhost:8081/api/4        - get by id
    http://localhost:8081/api/create   - create new person
    http://localhost:8081/api/delete/102      - delete by id
    */


    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPerson() {
        List<Person> personsList = personService.getAllPerson();
        if (personsList.isEmpty()) {
            return new ResponseEntity<>("There is no person in database", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(personsList, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savePerson = personService.savePerson(person);
        return new ResponseEntity<>(savePerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Integer id) {
        Optional<Person> person = personService.getPersonById(id);
        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>("There is no id associated in database with any person", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable Integer id) {
        try {
            boolean deleted = personService.deletePersonById(id);
            if (deleted) {
                return new ResponseEntity<>("Person with ID " + id + "deleted successfully.", HttpStatus.OK);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person with ID " + id + "not found for deletion.");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting person with ID " + id, e);
        }
    }
}


