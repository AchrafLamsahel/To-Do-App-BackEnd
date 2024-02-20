package ma.arkToDoApp.utils.DPCombinator;

public enum ValidationResult {
    SUCCESS("Success"),
    PHONE_NUMBER_NOT_VALID("Phone Number Not Valid"),
    FIRST_NAME_IS_NULL("Phone Number Not Valid"),
    EMAIL_NOT_VALID("Phone Number Not Valid"),
    LAST_NAME_IS_NULL("LastName is null"),
    STATUS_IS_NULL("status is null"),
    TITLE_IS_NULL("Title is null"),
    INVALID_DUE_DATE("Invalide due date");

    private final String msg;
    ValidationResult(String msg){
        this.msg = msg;
    }
    public String getMessage(){
        return this.msg;
    }
}
