package com.bryan.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionUserAnime {

    UUID getAnimeid();
    String getTitle();

    @JsonIgnoreProperties("favorites")
    Set<ProjectionUser> getFavoritedby();
}
