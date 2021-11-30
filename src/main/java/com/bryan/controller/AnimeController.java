package com.bryan.controller;

import com.bryan.domain.dto.Error;
import com.bryan.domain.dto.ResponseAnime;
import com.bryan.domain.model.Anime;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bryan.repository.AnimeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animes")
public class AnimeController {

 private  final AnimeRepository animeRepository;

    public AnimeController(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }
//hacer proyeccion para evitar un bucle entre atributos
    @GetMapping("/")
    public ResponseAnime showAnimejson(){
        return new ResponseAnime(animeRepository.findAll());
    }
/*
    @GetMapping("/")
    public List<Anime> showAnime(){
        return animeRepository.findAll();
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<?> getIndividualAnime(@PathVariable UUID id){
        Anime file = animeRepository.findById(id).orElse(null);

        if(file==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("No s'ha trobat l'anime amb ID: " + id));
        return ResponseEntity.ok().body(file);
    }


    @PostMapping("/")
    public ResponseEntity<?> createAnime(@RequestBody Anime anime)
    {
        for(Anime a : animeRepository.findAll()){
            if(a.getDescription().equals(anime.getDescription())){
                //409
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Error.message("Ja existeix un anime amb el nom '" + anime.getText() + "'"));
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
