package ru.reeson2003.user.exception;

/**
 * Date: 03.09.2017.
 * Time: 16:10.
 *
 * @author Pavel Gavrilov.
 */
public class DeletedUserException extends UnsupportedOperationException {
    public DeletedUserException() {
        super("User deleted");
    }
}
