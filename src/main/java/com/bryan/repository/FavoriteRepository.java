package com.bryan.repository;

import com.bryan.domain.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {

/*
    List<ProjectionUser> findBy();
    User findByUsername(String username);

    <T> List<T> findByUserid(UUID id, Class<T> type);
*/

}
/*

public interface UserRepository extends JpaRepository {

    User findByUsername(String username);
}*/
