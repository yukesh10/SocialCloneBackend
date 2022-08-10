package com.project.socialclone.clone.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
