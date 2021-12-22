package com.bryan.domain.model.projection;

import java.util.Set;
import java.util.UUID;

public interface ProjectionGenreById {
    UUID getGenreid();
    String getLabel();

    Set<ProjectionAnimeWithYear> getAnimes();

}
