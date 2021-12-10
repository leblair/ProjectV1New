package com.bryan.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionFindbyAuthorAnime {

    UUID getAnimeid();
    String getTitle();
    String getImage();

    @JsonIgnoreProperties("animes")
    Set<ProjectionAuthorWithAnimes> getAuthors();
}
