package uz.muhandis.microservicescourse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fildName;
    private Long fildValue;

    public ResourceNotFoundException(String resourceName, String fildName, Long fildValue) {
        super(String.format("%s not found with id %s: '%s'", resourceName, fildName, fildValue));
        this.fildName=fildName;
        this.resourceName=resourceName;
        this.fildValue=fildValue;
    }

}
