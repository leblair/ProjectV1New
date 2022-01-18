package com.bryan.controller;

import com.bryan.domain.dto.Error;
import com.bryan.domain.dto.ResponseList;
import com.bryan.domain.model.Anime;
import com.bryan.domain.model.projection.ProjectionAnimeAllFields;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bryan.repository.AnimeRepository;

import java.util.UUID;

@RestController
@RequestMapping("/animes")
public class AnimeController {

 private  final AnimeRepository animeRepository;

    public AnimeController(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }
    @GetMapping("/")
    public ResponseEntity<?> showAnimejson(){
        return ResponseEntity.ok().body(new ResponseList(animeRepository.findBy(ProjectionAnimeAllFields.class))) ;

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getIndividualAnime(@PathVariable UUID id){
        Anime anime = animeRepository.findById(id).orElse(null);

        if(anime==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("No s'ha trobat l'anime amb ID: " + id));
        return ResponseEntity.ok().body(anime);
    }


    @PostMapping("/")
    public ResponseEntity<?> createAnime(@RequestBody Anime anime)
    {
        for(Anime a : animeRepository.findAll()){
            if(a.description.equals(anime.description)){
                //409
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Error.message("Ja existeix un anime amb el nom '" + anime.title + "'"));
            }
        }
        return ResponseEntity.ok().body(animeRepository.save(anime));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnime(@PathVariable UUID id){
        for(Anime a: animeRepository.findAll()){
            if(a.animeid.equals(id)){
                animeRepository.delete(a);
                return ResponseEntity.ok().body("S'ha eliminat l'anime amd id '"+ a.animeid + "'");
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Error.message("No s'ha trobat l'anime amb id '" + id + "'"));
    }

}
