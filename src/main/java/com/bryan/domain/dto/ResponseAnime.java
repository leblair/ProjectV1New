package com.bryan.domain.dto;

import com.bryan.domain.model.Anime;

import java.util.List;

public class ResponseAnime {

    public List<Anime> result;

    public ResponseAnime(List<Anime> result) {
        this.result = result;
    }
}
