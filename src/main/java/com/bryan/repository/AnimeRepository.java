package com.bryan.repository;

import com.bryan.domain.dto.FilesResult;
import com.bryan.domain.model.Anime;
import com.bryan.domain.model.projection.ProjectionAnime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {
    List<ProjectionAnime> findBy();
}

/*public interface AuthorRepository extends JpaRepository<Author,UUID>{}*/
