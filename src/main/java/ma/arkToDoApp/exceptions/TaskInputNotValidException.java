package ma.arkToDoApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class TaskInputNotValidException extends RuntimeException{
    private String message;
    public TaskInputNotValidException(String message) {
        this.message = message;
    }
}
