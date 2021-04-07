package com.edu.udec.gdmtfl.msgdfiles.dtos;

import java.io.Serializable;
import java.util.Arrays;

public class DTOOutCreateFile implements Serializable {

    private static final long serialVersionUID = 1L;
    private String file;
    private String contentType;
    private String documentFamily;
    private long size;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDocumentFamily() {
        return documentFamily;
    }

    public void setDocumentFamily(String documentFamily) {
        this.documentFamily = documentFamily;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DTOOutCreateFile{" +
                "file='" + file + '\'' +
                ", contentType='" + contentType + '\'' +
                ", documentFamily='" + documentFamily + '\'' +
                ", size=" + size +
                '}';
    }
}
