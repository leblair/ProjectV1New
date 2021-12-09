package com.bryan.controller;

import com.bryan.domain.dto.ResponseList;
import com.bryan.repository.AnimeRepository;
import com.bryan.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    //hacer proyeccion para evitar un bucle entre atributos
    @GetMapping("/")
    public ResponseEntity<?> showAuthorJson(){
        return ResponseEntity.ok().body(new ResponseList(authorRepository.findBy())) ;
    }
}
