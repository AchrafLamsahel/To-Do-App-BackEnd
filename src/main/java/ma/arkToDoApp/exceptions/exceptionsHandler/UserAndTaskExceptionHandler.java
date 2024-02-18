package ma.arkToDoApp.exceptions.exceptionsHandler;

import ma.arkToDoApp.dtos.ErrorResponse;
import ma.arkToDoApp.exceptions.TaskInputNotValidException;
import ma.arkToDoApp.exceptions.TaskNotFoundException;
import ma.arkToDoApp.exceptions.UserInputNotValidException;
import ma.arkToDoApp.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice /**   Pour Intercepter Les Exceptions  */
public class UserAndTaskExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {UserInputNotValidException.class, TaskInputNotValidException.class})
    public final ResponseEntity<Object> handeInputNotValid(Exception ex, WebRequest request) {
        /*
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error =  new ErrorResponse("Server Error", details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
         */
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {TaskNotFoundException.class, UserNotFoundException.class})
    public final ResponseEntity<Object> handeNotFoundException(Exception ex, WebRequest request) {
        /*
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error =  new ErrorResponse("Server Error", details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
         */
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
