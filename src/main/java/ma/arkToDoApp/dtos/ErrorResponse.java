package ma.arkToDoApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter @Getter @AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;

}
