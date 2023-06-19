package uz.muhandis.microservicescourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.microservicescourse.entity.Person;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
}
