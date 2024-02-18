package ma.arkToDoApp.utils.DPCombinator;

import ma.arkToDoApp.dtos.TaskRequestDto;
import ma.arkToDoApp.entities.Task;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.Function;
import static ma.arkToDoApp.utils.DPCombinator.ValidationResult.*;
public interface TaskRegistrationValidator extends Function<TaskRequestDto, ValidationResult> {

    static TaskRegistrationValidator statusIsEmpty(){
        return taskRequestDto ->  !(taskRequestDto.getStatus().isEmpty()) ?
                 SUCCESS: STATUS_IS_NULL;
    }
    static TaskRegistrationValidator titleIsEmpty(){
        return taskRequestDto ->  !(taskRequestDto.getTitle().isEmpty()) ?
                SUCCESS : TITLE_IS_NULL;
    }
    public static TaskRegistrationValidator dueDateIsValid() {
        return taskRequestDto -> {
            if (taskRequestDto.getDueDate() != null) {
                LocalDate dueDate = taskRequestDto.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return LocalDate.now().isBefore(dueDate) ? SUCCESS : INVALID_DUE_DATE;
            } else {
                return INVALID_DUE_DATE;
            }
        };
    }

    default TaskRegistrationValidator and(TaskRegistrationValidator other) {
        return taskRequestDto -> {
            ValidationResult result = this.apply(taskRequestDto);
            return result.equals(SUCCESS) ? other.apply(taskRequestDto) : result;
        };
    }

    default TaskRegistrationValidator or(TaskRegistrationValidator other) {
        return taskRequestDto -> {
            ValidationResult result = this.apply(taskRequestDto);
            return result.equals(SUCCESS) ? SUCCESS : other.apply(taskRequestDto);
        };
    }

}
