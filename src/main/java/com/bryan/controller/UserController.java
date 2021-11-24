package com.bryan.controller;

import com.bryan.domain.dto.Error;
import com.bryan.domain.model.Anime;
import com.bryan.domain.model.User;
import com.bryan.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> usersList(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIndividualAnime(@PathVariable UUID id){
        User file = userRepository.findById(id).orElse(null);

        if(file==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("No s'ha trobat l'usuari amb ID: " + id));
        return ResponseEntity.ok().body(file);
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody User user){
        for(User u : userRepository.findAll()){
            if(u.username.equals(user.username)){
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Error.message("Ja existeix un usuari amb el nom '" + user.username + "'"));
            }
        }
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        for(User u : userRepository.findAll()){
            if(u.userid.equals(id)){
                userRepository.delete(u);
                return ResponseEntity.ok().body("S'ha eliminat l'usuari amd id '"+ u.userid + "'");
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Error.message("No s'ha trobat l'usuari amb id '" + id + "'"));
    }



}
