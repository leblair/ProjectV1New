package com.bryan.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface  ProjectionAuthorWithAnimes{
    UUID getAuthorid();
    String getNAm();
    @JsonIgnoreProperties("authors")
    Set<ProjectionFindbyAuthorAnime> getAnimes();

}
