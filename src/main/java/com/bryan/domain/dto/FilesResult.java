package com.bryan.domain.dto;


import java.util.UUID;

public class FilesResult {

    public UUID fileid;
    public String contenttype;

    public FilesResult(UUID fileid, String contenttype) {
        this.fileid = fileid;
        this.contenttype = contenttype;
    } //solo poner un constructor, si no no funciona

    public UUID getFileid() {
        return fileid;
    }

    public void setFileid(UUID fileid) {
        this.fileid = fileid;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }
}
