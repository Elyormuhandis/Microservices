package uz.muhandis.microservicescourse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhandis.microservicescourse.dto.PersonDto;
import uz.muhandis.microservicescourse.entity.Person;
import uz.muhandis.microservicescourse.mapper.PersonMapper;
import uz.muhandis.microservicescourse.repository.PeopleRepository;
import uz.muhandis.microservicescourse.service.PeopleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;


    @Override
    public List<PersonDto> getPeople() {
        List<Person> people = peopleRepository.findAll();
        return people.stream().map(PersonMapper::personToPersonDto).collect(Collectors.toList());
    }
    @Override
    public PersonDto getPerson(Long personId) {
        Optional<Person> person = peopleRepository.findById(personId);
        return PersonMapper.personToPersonDto(person.get());
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = peopleRepository.save(PersonMapper.personDtoToPerson(personDto));
        return PersonMapper.personToPersonDto(person);
    }


    @Override
    public PersonDto updatePerson(PersonDto personDto, Long personId) {
        personDto.setId(personId);
        Optional<Person> personOptional = peopleRepository.findById(personId);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person = PersonMapper.personDtoToPerson(personDto);
            return PersonMapper.personToPersonDto(peopleRepository.save(person));
        }
        return new PersonDto();
    }

    @Override
    public String deletePerson(Long personId) {
        peopleRepository.deleteById(personId);
        return "Successfully deleted!";
    }
}
