package com.bryan.repository;

import com.bryan.domain.model.Author;
import com.bryan.domain.model.projection.ProjectionAuthorWithAnimes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    List<ProjectionAuthorWithAnimes> findBy();
}
