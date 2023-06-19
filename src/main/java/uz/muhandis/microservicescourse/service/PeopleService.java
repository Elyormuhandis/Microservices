package uz.muhandis.microservicescourse.service;

import org.springframework.stereotype.Service;
import uz.muhandis.microservicescourse.dto.PersonDto;

import java.util.List;

@Service
public interface PeopleService {
    public List<PersonDto> getPeople();
    public PersonDto getPerson(Long personId);
    public PersonDto createPerson(PersonDto personDto);
    public PersonDto updatePerson(PersonDto personDto);

    public String deletePerson(Long personId);
}
