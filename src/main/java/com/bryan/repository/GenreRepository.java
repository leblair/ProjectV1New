package com.bryan.repository;

import com.bryan.domain.model.FileTable;
import com.bryan.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository  extends JpaRepository<Genre, UUID> {
}
