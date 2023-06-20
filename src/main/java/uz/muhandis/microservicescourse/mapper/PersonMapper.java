package uz.muhandis.microservicescourse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.muhandis.microservicescourse.dto.PersonDto;
import uz.muhandis.microservicescourse.entity.Person;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface PersonMapper {

    PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);


    PersonDto personToPersonDto(Person person);

    @Mapping(target = "age", defaultValue = "15")
    @Mapping(target="createdDate",ignore = true, defaultExpression = "java(java.time.LocalDateTime.now())")
    Person personDtoToPerson(PersonDto personDto);
}
