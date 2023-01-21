package com.project.backend.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    @Serial
    private static final long serialVersionUID = 1L;

}
