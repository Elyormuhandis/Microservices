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


    PersonDto personToDto(Person person);
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Person dtoToPerson(PersonDto personDto);
}
