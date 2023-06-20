package uz.muhandis.microservicescourse.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    @NotEmpty(message = "First name shouldn't be empty!")
    private String firstName;
    @NotEmpty(message = "Last name shouldn't be empty!")
    private String lastName;
    @NotEmpty(message = "Email address shouldn't be empty!")
    @Email(message = "Wrong email!")
    private String email;
    @Min(value = 0, message = "Age should be greater than zero!")
    private Integer age;


}
