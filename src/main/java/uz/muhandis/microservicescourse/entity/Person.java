package uz.muhandis.microservicescourse.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "Person")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @Column(name="created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;


}
