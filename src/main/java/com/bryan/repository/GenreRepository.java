package com.bryan.repository;

import com.bryan.domain.model.FileTable;
import com.bryan.domain.model.Genre;
import com.bryan.domain.model.projection.ProjectionGenreById;
import com.bryan.domain.model.projection.ProjectionGetAllGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GenreRepository  extends JpaRepository<Genre, UUID> {
    List<ProjectionGetAllGenre> findBy();
    <T> T findByGenreid(UUID genreid, Class<T> type);

}
