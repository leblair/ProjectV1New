package com.bryan.repository;

import com.bryan.domain.dto.UserResult;
import com.bryan.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;



public interface UserRepository extends JpaRepository<User, UUID> {

    List<UserResult> findBy();
    User findByUsername(String username);

}
/*

public interface UserRepository extends JpaRepository {

    User findByUsername(String username);
}*/
