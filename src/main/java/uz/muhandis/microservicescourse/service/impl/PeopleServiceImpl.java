package uz.muhandis.microservicescourse.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.muhandis.microservicescourse.dto.PersonDto;
import uz.muhandis.microservicescourse.entity.Person;
import uz.muhandis.microservicescourse.exceptions.EmailAlreadyExistsException;
import uz.muhandis.microservicescourse.exceptions.ResourceNotFoundException;
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
    private final ModelMapper modelMapper;

    @Override
    public List<PersonDto> getPeople() {
        List<Person> people = peopleRepository.findAll();
        return people.stream().map(person -> PersonMapper.MAPPER.personToDto(person)).collect(Collectors.toList());
    }

    @Override
    public PersonDto getPerson(final Long personId) {
        Person person = peopleRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));
        return PersonMapper.MAPPER.personToDto(person);
    }

    @Override
    public PersonDto createPerson(final PersonDto personDto) {
        Optional<Person> optionalPerson = peopleRepository.findByEmail(personDto.getEmail());
        if (optionalPerson.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists for person");
        }
        Person person = peopleRepository.save(PersonMapper.MAPPER.dtoToPerson(personDto));
        return PersonMapper.MAPPER.personToDto(person);
    }


    @Override
    public PersonDto updatePerson(final PersonDto personDto) {
        personDto.setId(personDto.getId());
        Person person = peopleRepository.findById(personDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Person", "id", personDto.getId()));
        person = modelMapper.map(personDto, Person.class);
        Person updatedPerson = peopleRepository.save(person);
        return PersonMapper.MAPPER.personToDto(updatedPerson);
    }

    @Override
    public String deletePerson(final Long personId) {
        peopleRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));
        peopleRepository.deleteById(personId);
        return "Successfully deleted!";
    }
}
