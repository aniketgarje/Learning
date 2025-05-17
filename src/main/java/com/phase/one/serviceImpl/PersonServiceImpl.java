package com.phase.one.serviceImpl;

import com.phase.one.model.Person;
import com.phase.one.repository.PersonRepository;
import com.phase.one.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public boolean deletePersonById(Integer id) {
        if(personRepository.existsById(id)){
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
