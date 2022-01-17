package com.bryan.repository;

import com.bryan.domain.model.Favorite;
import com.bryan.domain.model.User;
import com.bryan.domain.model.projection.ProjectionUserAnime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {


 /*   List<ProjectionUserAnime> list = new ArrayList<>();
    User findByUsername(String username);

    <T> List<T> findByUserid(UUID id, Class<T> type);
*/

}
/*

public interface UserRepository extends JpaRepository {

    User findByUsername(String username);
}*/
