package ma.arkToDoApp.utils.ManualValidator;

import ma.arkToDoApp.entities.User;

public class UserValidatorService {
    private boolean isEmailValid(String email){
        return (email.contains("@") && email.endsWith("gmail.com"));
    }

    private boolean isPhoneNumberValid(String phoneNumber){
        return ( phoneNumber.startsWith("+212") && phoneNumber.length() == 13 ) ||
                ( phoneNumber.length() == 10 && phoneNumber.startsWith("0"));
    }

    public boolean personIsValid(User user){
        return isEmailValid(user.getEmail()) && isPhoneNumberValid(user.getEmail());
    }

}
