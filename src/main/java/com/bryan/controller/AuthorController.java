package com.bryan.controller;

import com.bryan.domain.dto.Error;
import com.bryan.domain.dto.ResponseList;
import com.bryan.domain.model.Author;
import com.bryan.repository.AnimeRepository;
import com.bryan.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @GetMapping("/")
    public ResponseEntity<?> showAuthorJson(){
        return ResponseEntity.ok().body(new ResponseList(authorRepository.findBy())) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> id(@PathVariable UUID id){
        Author author = authorRepository.findById(id).orElse(null);

        if (author == null)
            // error 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Error.message("No s'ha trobat l'autor amd id " + id));
        else
            return ResponseEntity.ok().body(author);
    }
}
