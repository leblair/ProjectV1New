package com.bryan.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnimeAllFields {
    UUID getAnimeid();
    String getTitle();
    String getDescription();
    String getType();
    int getYear();
    String getImage();


    @JsonIgnoreProperties("animes")
    Set<ProjectionAuthorWithAnimes> getAuthors();

    @JsonIgnoreProperties("authors")
    Set<ProjectionGetAllGenre_Anime> getGenres();

    @JsonIgnoreProperties("favorites")
    Set<ProjectionUser> getFavoritedby();
}
