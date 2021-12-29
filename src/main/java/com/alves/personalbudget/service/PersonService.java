package com.alves.personalbudget.service;

import com.alves.personalbudget.model.Person;
import com.alves.personalbudget.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person update(Long id, Person person) {
        Person persistedPerson = findById(id).get();

        persistedPerson.getContacts().clear();
        persistedPerson.getContacts().addAll(person.getContacts());
        persistedPerson.getContacts().forEach(c -> c.setPerson(persistedPerson));

        BeanUtils.copyProperties(person, persistedPerson, "id", "contacts");
        return repository.save(persistedPerson);
    }

    public void updateActive(Long id, Boolean active) {
        Person persistedPerson = findById(id).get();
        persistedPerson.setActive(active);
        repository.save(persistedPerson);
    }

    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1)));
    }

    public Person save(Person person) {
        person.getContacts().forEach(c -> c.setPerson(person));
        person.setActive(true);
        return repository.save(person);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Page<Person> findByNameContaining(String name, Pageable pageable) {
        return repository.findByNameContaining(name, pageable);
    }
}
