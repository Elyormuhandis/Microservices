package uz.muhandis.microservicescourse.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.microservicescourse.dto.PersonDto;
import uz.muhandis.microservicescourse.service.PeopleService;

import java.util.List;


@Tag(name = "CRUD REST APIs for Person Resource",
        description = "CRUD REST APIs - CREATE Person, GET Person, GET People, UPDATE Person, DELETE Person")
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

    @Operation(summary = "CREATE PERSON REST API",
            description = "CREATE PERSON REST API is used to save person in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody @Valid PersonDto personDto) {

        return ResponseEntity.ok(peopleService.createPerson(personDto));
    }

    @PutMapping
    public ResponseEntity<PersonDto> updatePerson(@RequestBody @Valid PersonDto personDto) {
        return ResponseEntity.ok(peopleService.updatePerson(personDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long personId) {
        return ResponseEntity.ok(peopleService.deletePerson(personId));
    }

}
