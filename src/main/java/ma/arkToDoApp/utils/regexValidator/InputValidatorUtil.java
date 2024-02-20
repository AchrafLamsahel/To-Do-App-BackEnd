package ma.arkToDoApp.utils.regexValidator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class InputValidatorUtil {
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
    public static boolean isValidPhone(String phoneNumber) {
        String regexFixe = "^0\\d{9}$";
        String regexMobile = "^(06|07)\\d{8}$";
        String regexInternational = "^\\+212\\d{9}$";
        return phoneNumber.matches(regexFixe) ||
                phoneNumber.matches(regexMobile) ||
                phoneNumber.matches(regexInternational);
    }

    private boolean dueDateIsValid(Date date) {
        if (date != null) {
            LocalDate dueDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return LocalDate.now().isBefore(dueDate);
        } else {
            return false;
        }
    }

}
