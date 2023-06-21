package uz.muhandis.microservicescourse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Schema(description = "Person Model Information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    @Schema(description = "First name for Person")
    @NotEmpty(message = "First name shouldn't be empty!")
    private String firstName;
    @Schema(description = "Last name for Person")
    @NotEmpty(message = "Last name shouldn't be empty!")
    private String lastName;
    @Schema(description = "Email address for Person")
    @NotEmpty(message = "Email address shouldn't be empty!")
    @Email(message = "Wrong email!")
    private String email;
    @Schema(description = "Age of Person")
    @Min(value = 0, message = "Age should be greater than zero!")
    private Integer age;


}
