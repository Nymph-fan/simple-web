package com.web.exception;

/**
 * @author anyun
 * @date 2017/6/13
 * @time 16:57
 * @description
 */
public class UserExistException extends Exception {

    public UserExistException() {
        super();
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }
}
