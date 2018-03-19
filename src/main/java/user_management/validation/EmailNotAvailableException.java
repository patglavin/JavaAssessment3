package user_management.validation;

public class EmailNotAvailableException extends Throwable{
    public String getMessage(){
        return "This email is not available!";
    }
}
