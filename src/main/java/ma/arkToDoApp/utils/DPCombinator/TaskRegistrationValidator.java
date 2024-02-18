package ma.arkToDoApp.utils.DPCombinator;

import ma.arkToDoApp.dtos.TaskRequestDto;
import ma.arkToDoApp.entities.Task;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.Function;
import static ma.arkToDoApp.utils.DPCombinator.ValidationResult.*;
public interface TaskRegistrationValidator extends Function<TaskRequestDto, ValidationResult> {

    static TaskRegistrationValidator statusIsValid(){
        return Task ->  !Task.getStatus().isEmpty() ?
                 SUCCESS: STATUS_IS_NULL;
    }
    static TaskRegistrationValidator titleIsValid(){
        return user ->  !user.getTitle().isEmpty() ?
                SUCCESS : TITLE_IS_NULL;
    }
    static TaskRegistrationValidator dueDateIsValid(){
        return task -> {
            if (task.getDueDate() != null) {
                LocalDate dueDate = task.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                return LocalDate.now().isBefore(dueDate) ? SUCCESS : INVALID_DUE_DATE;
            } else {
                return INVALID_DUE_DATE;
            }
        };
    }

    default TaskRegistrationValidator and(TaskRegistrationValidator other) {
        return task -> {
            ValidationResult result = this.apply(task);
            return result.equals(SUCCESS) ? other.apply(task) : result;
        };
    }

    default TaskRegistrationValidator or(TaskRegistrationValidator other) {
        return task -> {
            ValidationResult result = this.apply(task);
            return result.equals(SUCCESS) ? SUCCESS : other.apply(task);
        };
    }

}
