package com.bryan.domain.model.projection;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnimeWithYear {
    UUID getAnimeid();
    String getTitle();
    String getType();
    String getYear();
    String getImage();

    Set<ProjectionIdGenreAuthors> getAuthors();

}
