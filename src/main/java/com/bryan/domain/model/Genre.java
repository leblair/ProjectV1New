package com.bryan.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;



@Entity
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID genreid;

    public String label;

    @ManyToMany(mappedBy = "genres")
    public Set<Anime> animes;
    /*@ManyToMany
    @JoinTable(name= "anime_author", joinColumns = @JoinColumn(name = "authorid"),inverseJoinColumns = @JoinColumn(name = "animeid"))

    @JsonIgnoreProperties("authors") //cambiar
    public Set<Anime> animes;*/
}