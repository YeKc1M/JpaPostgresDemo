package com.example.postgresdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person){return personRepository.save(person);}

    public List<Person> list(){
        return personRepository.findAll();
    }

    public Person update(Person person){
        return personRepository.saveAndFlush(person);
    }
}
