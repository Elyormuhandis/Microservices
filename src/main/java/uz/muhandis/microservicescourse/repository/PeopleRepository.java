package uz.muhandis.microservicescourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.microservicescourse.entity.Person;

public interface PeopleRepository extends JpaRepository<Person, Long> {

}
