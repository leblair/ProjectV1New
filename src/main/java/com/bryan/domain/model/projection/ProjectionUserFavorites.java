package com.bryan.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

public interface ProjectionUserFavorites {
    @JsonIgnoreProperties("favoritedby")
    Set<ProjectionFavoriteAnime> getFavorites();
}
