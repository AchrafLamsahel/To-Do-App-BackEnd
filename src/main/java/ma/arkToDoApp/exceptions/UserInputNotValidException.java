package ma.arkToDoApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UserInputNotValidException extends RuntimeException{
    private String message;
    public UserInputNotValidException(String message) {
        this.message = message;
    }
}
