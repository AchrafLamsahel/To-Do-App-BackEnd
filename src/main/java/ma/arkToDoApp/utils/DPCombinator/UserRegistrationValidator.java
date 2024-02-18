package ma.arkToDoApp.utils.DPCombinator;

import ma.arkToDoApp.dtos.UserRequestDto;
import java.util.function.Function;
import static ma.arkToDoApp.utils.DPCombinator.ValidationResult.*;
public interface UserRegistrationValidator extends Function<UserRequestDto, ValidationResult> {
    static UserRegistrationValidator isEmailValid(){
        return user ->( user.getEmail().contains("@")
                &&  user.getEmail().endsWith("gmail.com")
                && !(user.getEmail().startsWith("@"))) ?
                SUCCESS : EMAIL_NOT_VALID;
    }

    static UserRegistrationValidator firstNameIsValid(){
        return user ->  !(user.getFirstName().isEmpty()) ?
                SUCCESS : FIRST_NAME_IS_NULL;
    }

    static UserRegistrationValidator lastNameIsValid(){
        return user ->  !(user.getFirstName().isEmpty()) ?
                SUCCESS : LAST_NAME_IS_NULL;
    }

    default UserRegistrationValidator and(UserRegistrationValidator other){
        return user-> {
            ValidationResult result = this.apply(user);
            return result.equals(SUCCESS) ? other.apply(user) : result;
        };
    }

    /**
     static UserRegistrationValidator isNumberValid(){
     return user -> user.getEmail().startsWith("+212") ?
     SUCCESS : PHONE_NUMBER_NOT_VALID;
     }
     */

}
