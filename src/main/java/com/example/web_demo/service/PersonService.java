package com.example.web_demo.service;

import com.example.web_demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    List<Person> persons;

    @Autowired
    public PersonService() {
        this.persons = new ArrayList<>();
        persons.add(new Person("Sári", LocalDate.now(),"sari@exemple.com"));
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void savePerson(Person person) {
        persons.add(person);
    }

    public void deletePerson(Person person) {
        persons.remove(person);
    }

    public void deletePersonByName(String name) {
        for (int i = 0; i < persons.size(); i++) {
            if(persons.get(i).getName().equals(name)){
                persons.remove(i);
                i--;
            }
        }
    }
}
