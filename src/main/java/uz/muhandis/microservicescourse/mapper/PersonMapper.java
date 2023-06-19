package uz.muhandis.microservicescourse.mapper;

import uz.muhandis.microservicescourse.dto.PersonDto;
import uz.muhandis.microservicescourse.entity.Person;

public class PersonMapper {
    public static PersonDto personToPersonDto(Person person) {
        return new PersonDto(person.getId(), person.getFirstName(), person.getLastName(), person.getEmail());
    }

    public static Person personDtoToPerson(PersonDto personDto) {
        return new Person(personDto.getId(), personDto.getFirstName(), personDto.getLastName(), personDto.getEmail());
    }
}
