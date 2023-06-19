package uz.muhandis.microservicescourse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uz.muhandis.microservicescourse.dto.PersonDto;
import uz.muhandis.microservicescourse.entity.Person;

@Mapper
public interface PersonMapper {

    PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);

    PersonDto personToPersonDto(Person person);

    Person personDtoToPerson(PersonDto personDto);
}
