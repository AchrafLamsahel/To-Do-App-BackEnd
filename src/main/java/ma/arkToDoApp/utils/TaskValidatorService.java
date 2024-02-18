package ma.arkToDoApp.utils;

import java.util.Date;

public class TaskValidatorService {
    private boolean titleIsValid(String title){
        return !(title.isEmpty());
    }
    private boolean statusIsValid(String status){
        return !(status.isEmpty());
    }
    private boolean dueDateIsValid(Date date){
        return ( date.before(new Date()) ); // fixer cette methode
    }



}
