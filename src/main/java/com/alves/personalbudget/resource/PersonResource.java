package com.alves.personalbudget.resource;

import com.alves.personalbudget.dto.PersonDTO;
import com.alves.personalbudget.event.ResourceCreatedEvent;
import com.alves.personalbudget.model.Person;
import com.alves.personalbudget.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    HttpServletResponse response;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private PersonService service;

    @Autowired
    private ModelMapper modelMapper ;

    @PostMapping
    public ResponseEntity<Person> add(@Valid @RequestBody PersonDTO personDTO) {
       Person person = this.modelMapper.map(personDTO, Person.class);
       Person persistedPerson = service.save(person);
       publisher.publishEvent(new ResourceCreatedEvent(this, response, persistedPerson.getId()));
       return ResponseEntity.status(HttpStatus.CREATED).body(persistedPerson);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Optional<Person> pessoa = service.findById(id);
        return pessoa.isPresent() ? ResponseEntity.ok(pessoa.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person person) {
        Person personPersisted = service.update(id, person);
        return ResponseEntity.ok(personPersisted);
    }

    @PutMapping("/{id}/active")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateActive(@PathVariable Long id, @RequestBody Boolean active) {
        service.updateActive(id, active);
    }

    @GetMapping
    public Page<Person> findByNameContaining(@RequestParam(required = false, defaultValue = "") String name,
                                             Pageable pageable) {
        return service.findByNameContaining(name, pageable);
    }

}
