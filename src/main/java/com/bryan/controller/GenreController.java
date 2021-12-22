package com.bryan.controller;

import com.bryan.domain.dto.Error;
import com.bryan.domain.dto.ResponseList;
import com.bryan.domain.model.Genre;
import com.bryan.domain.model.projection.ProjectionGenreById;
import com.bryan.domain.model.projection.ProjectionGetAllGenre;
import com.bryan.repository.GenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> genresJson(){
        return ResponseEntity.ok().body( new ResponseList(genreRepository.findBy()) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> id(@PathVariable UUID id){
        Genre genre = genreRepository.findById(id).orElse(null);

        if (genre == null)
            // error 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Error.message("No s'ha trobat el genre amd id " + id));
        else
            return ResponseEntity.ok().body(genreRepository.findByGenreid(id, ProjectionGenreById.class));
    }
}
