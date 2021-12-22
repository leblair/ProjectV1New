package com.bryan.repository;

import com.bryan.domain.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {
}

