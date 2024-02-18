package ma.arkToDoApp.utils.ManualValidator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TaskValidatorService {
    private boolean titleIsValid(String title){
        return !(title.isEmpty());
    }
    private boolean statusIsValid(String status){
        return !(status.isEmpty());
    }
    private boolean dueDateIsValid(Date date){
        if (date != null) {
            LocalDate dueDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return LocalDate.now().isBefore(dueDate);
        } else {
            return false;
        }
    }



}
