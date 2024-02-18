package ma.arkToDoApp.utils.regexValidator;

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

}
