package com.bryan.domain.model.projection;

import java.util.Set;
import java.util.UUID;

public interface ProjectionGetAllGenre {
    UUID getGenreid();
    String getLabel();

    Set<ProjectionGetAllGenre_Anime> getAnimes();

}
