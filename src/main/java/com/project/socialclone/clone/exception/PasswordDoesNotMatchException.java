package com.project.socialclone.clone.exception;

public class PasswordDoesNotMatchException extends RuntimeException{

    public PasswordDoesNotMatchException(String message){
        super(message);
    }

}
