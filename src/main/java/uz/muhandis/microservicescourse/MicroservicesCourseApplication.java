package uz.muhandis.microservicescourse;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(
        info = @Info(
                title = "Spring boot REST API Documentation",
                description = "Spring boot REST API Docs",
                version = "1.0",
                contact = @Contact(
                        name = "Elyor",
                        url = "www.muhandis.uz",
                        email = "elyormuhandis@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "www.apache.com"
                )
        ),
        externalDocs = @ExternalDocumentation(description = "Spring boot docs", url = "spring.docs.io")
)
public class MicroservicesCourseApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesCourseApplication.class, args);
    }

}
