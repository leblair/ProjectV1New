package controller;

import domain.dto.Error;
import domain.dto.ResponseAnime;
import domain.model.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.AnimeRepository;

import java.util.UUID;

@RestController
@RequestMapping("/anime")
public class AnimeController {

 private  final AnimeRepository animeRepository;

    public AnimeController(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @GetMapping("/")
    public ResponseAnime showAnimejson(){
        return new ResponseAnime(animeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIndividualAnime(@PathVariable UUID id){
        Anime file = animeRepository.findById(id).orElse(null);

        if(file==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("No s'ha trobat l'anime amb ID: " + id));
        return ResponseEntity.ok().body(file);
    }


    @PostMapping("/")
    public Anime createAnime(@RequestBody Anime anime)
    {

        return animeRepository.save(anime);
    }

}
