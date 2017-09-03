package ru.reeson2003.user.exception;

/**
 * Date: 02.09.2017.
 * Time: 10:59.
 *
 * @author Pavel Gavrilov.
 */
public class CreateUserException extends Exception {
    public CreateUserException() {
    }

    public CreateUserException(String message) {
        super(message);
    }

    public CreateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateUserException(Throwable cause) {
        super(cause);
    }

    public CreateUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
