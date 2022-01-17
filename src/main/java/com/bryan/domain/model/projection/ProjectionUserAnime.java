package com.bryan.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionUserAnime {

    UUID getAnimeid();
    String getTitle();
    String getImage();

    @JsonIgnoreProperties("favorites")
    Set<ProjectionUser> getFavoritedby();
}
