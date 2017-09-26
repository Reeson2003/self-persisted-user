package ru.reeson2003.user.exception;

/**
 * Date: 03.09.2017.
 * Time: 16:21.
 *
 * @author Pavel Gavrilov.
 */
public class SearchUserException extends Exception{
    public SearchUserException() {
        super("User not found");
    }
}
