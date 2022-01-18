package com.bryan.domain.model.projection;

import com.bryan.domain.model.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

   @JsonIgnoreProperties("animes")
    Set<ProjectionGenreById> getGenres();

    @JsonIgnoreProperties("favorites")
    Set<ProjectionUser> getFavoritedby();
}
