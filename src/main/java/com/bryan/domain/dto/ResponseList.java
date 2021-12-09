package com.bryan.domain.dto;

import com.bryan.domain.model.Anime;

import java.util.List;

public class ResponseList {

    public List<?> result;

    public ResponseList(List<?> result) {
        this.result = result;
    }
}
