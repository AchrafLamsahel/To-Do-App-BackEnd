package ma.arkToDoApp.dtos;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }
}
