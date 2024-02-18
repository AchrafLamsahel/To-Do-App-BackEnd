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
import java.util.Date;
import java.util.List;
@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice /**   Pour Intercepter Les Exceptions  */
public class UserAndTaskExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {UserInputNotValidException.class, TaskInputNotValidException.class})
    public final ResponseEntity<ErrorResponse> handeInputNotValid(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusNumber(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(new Date());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {TaskNotFoundException.class, UserNotFoundException.class})
    public final ResponseEntity<ErrorResponse> handeNotFoundException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusNumber(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(new Date());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }

}
