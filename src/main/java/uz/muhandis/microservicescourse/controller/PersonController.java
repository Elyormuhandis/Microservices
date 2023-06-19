package uz.muhandis.microservicescourse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.microservicescourse.dto.PersonDto;
import uz.muhandis.microservicescourse.service.PeopleService;

import java.util.List;

@RestController
@RequestMapping("api/people")
@RequiredArgsConstructor
public class PersonController {

    private final PeopleService peopleService;


    @GetMapping
    public ResponseEntity<List<PersonDto>> getPeople() {
        return ResponseEntity.ok(peopleService.getPeople());
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable("id") Long personId) {
        return ResponseEntity.ok(peopleService.getPerson(personId));
    }

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(peopleService.createPerson(personDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") Long personId, @RequestBody PersonDto personDto) {
        return ResponseEntity.ok(peopleService.updatePerson(personDto, personId));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long personId) {
        return ResponseEntity.ok(peopleService.deletePerson(personId));
    }
}
