package com.edu.udec.gdmtfl.msgdfiles.dtos;

public class DTOResponseMessage {

    private String file;

    public DTOResponseMessage(String message) {
        this.file = message;
    }

    public String getMessage() {
        return file;
    }

    public void setMessage(String message) {
        this.file = message;
    }
}
