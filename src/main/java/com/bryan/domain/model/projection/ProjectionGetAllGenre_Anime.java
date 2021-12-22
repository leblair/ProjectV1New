package com.bryan.domain.model.projection;

import java.util.Set;
import java.util.UUID;

public interface ProjectionGetAllGenre_Anime {
    UUID getAnimeid();
    String getTitle();
    String getType();
    String getImage();

    Set<ProjectionGetAllGenre_Anime_Author> getAuthors();

}
