package com.bryan.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface  ProjectionAuthorWithAnimes{
    UUID getAuthorid();
    String getName();
    String getImageurl();
    @JsonIgnoreProperties("authors")
    Set<ProjectionFindbyAuthorAnime> getAnimes();

}
