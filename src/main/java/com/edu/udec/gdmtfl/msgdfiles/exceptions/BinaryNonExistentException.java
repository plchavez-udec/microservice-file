package com.edu.udec.gdmtfl.msgdfiles.exceptions;

public class BinaryNonExistentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final String MENSAJE="BINARY %s DOES NOT EXIST";

    public BinaryNonExistentException(String message) {
        super(String.format(MENSAJE, message));
    }
}
