package uz.pdp.exceptions;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private String message = "User not found with given criteria";
    public UserNotFoundException() {
        super("User not found with given criteria");
    }
    public UserNotFoundException(String message) {
        super(message);
    }

}
