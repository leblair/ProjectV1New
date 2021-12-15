package com.bryan.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID animeid;

    public String title;
    public String description;
    public String type;
    public int year;
    public String image;

    @ManyToMany//(mappedBy = "animes")//cambiar
    @JsonIgnoreProperties("animes")
    public Set<Author> authors;

    @ManyToMany
    @JoinTable(name="anime_genre",joinColumns = @JoinColumn(name="animeid"),
            inverseJoinColumns = @JoinColumn(name="genreid"))
    public Set<Genre> genres;

    /*@ManyToMany
    @JoinTable(name= "favorite", joinColumns = @JoinColumn(name = "animeid"),inverseJoinColumns = @JoinColumn(name = "userid"))

//    @JsonIgnoreProperties("authors") //cambiar
    public Set<User> favoritedby;//marcada fav por el set de usuarios*/

}
