package com.project.backend.exceptions;

public class InvalidTransferException extends RuntimeException{
    public InvalidTransferException(String msg) {
        super(msg);
    }
}
