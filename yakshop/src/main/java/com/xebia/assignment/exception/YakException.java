package com.xebia.assignment.exception;

/**
 * This is the Main Exception class for the all exceptions of the application
 *
 */
public class YakException extends Exception {
    public YakException() { super(); }
    public YakException(String message) { super(message); }
    public YakException(String message, Throwable cause) { super(message, cause); }
    public YakException(Throwable cause) { super(cause); }

}
