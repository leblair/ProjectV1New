package com.bryan.domain.dto;

import com.bryan.domain.model.FileTable;

import java.util.List;

public class ResponseFile {
    public List<FilesResult> result;

    public ResponseFile(List<FilesResult> result) {
        this.result = result;
    }
}