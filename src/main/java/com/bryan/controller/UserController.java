package com.bryan.controller;

import com.bryan.domain.dto.*;
import com.bryan.domain.dto.Error;
import com.bryan.domain.model.Favorite;
import com.bryan.domain.model.User;
import com.bryan.repository.FavoriteRepository;
import com.bryan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired private FavoriteRepository favoriteRe;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> usersList(){
        return ResponseEntity.ok().body(new ResponseList(userRepository.findBy()));
    }

    /*/
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id){
        User file = userRepository.findById(id).orElse(null);

        if(file==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("No s'ha trobat l'usuari amb ID: " + id));
        return ResponseEntity.ok().body(file);
    }
*/


    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserRegisterRequest userRegisterRequest){
        if (userRepository.findByUsername(userRegisterRequest.username) == null) {
            User userNuevo = new User();
            userNuevo.username = userRegisterRequest.username;
            userNuevo.password = passwordEncoder.encode(userRegisterRequest.password);
            userRepository.save(userNuevo);

            UserResult userResult = new UserResult(userNuevo.userid,userNuevo.username);

            return ResponseEntity.ok().body(userResult);//OK
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Ja existeix un usuari amb el nom '" + userRegisterRequest.username + "'");

    }

    @PostMapping("/{id}/favorites")
    public ResponseEntity<?> addFavorite(@RequestBody Favorite favorite, Authentication authentication){
        ;

        if(userRepository.findByUsername(authentication.getName()).userid.equals(favorite.userid)) {

            favoriteRe.save(favorite);
            return ResponseEntity.ok().build();
        }
        else {

            return  ResponseEntity.ok().body("");
        }

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

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUsers(){
        userRepository.deleteAll();
        return ResponseEntity.ok().body("Usuaris borrats.");
    }
}


/*
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterRequest userRegisterRequest) {

        if (userRepository.findByUsername(userRegisterRequest.username) == null) {
            User user = new User();
            user.username = userRegisterRequest.username;
            user.password = passwordEncoder.encode(userRegisterRequest.password);
            user.enabled = true;
            userRepository.save(user);
            return "OK";   // TODO
        }
        return "ERROR";    // TODO
    }
}*/