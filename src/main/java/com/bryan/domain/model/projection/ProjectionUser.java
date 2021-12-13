package com.bryan.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionUser {

    UUID getUserid();
    String getUsername();

    @JsonIgnoreProperties("favoritedby")
    Set<ProjectionUserAnime> getFavorites();
}
