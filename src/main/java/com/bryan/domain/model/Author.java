package com.bryan.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID authorid;

    public String name;
    public String imageurl;

    @ManyToMany(mappedBy = "authors")//relacion n:m
    public Set<Anime> animes;

    @ManyToMany
    @JoinTable(name= "anime_author", joinColumns = @JoinColumn(name = "animeid"),inverseJoinColumns = @JoinColumn(name = "authorid"))
    public Set<Author> authors;

    public interface  ProjectionAuthorWithAnimes{
        UUID getAuthorid();
        String getName();
        @JsonIgnoreProperties("actors")
        Set<ProjectionAuthorWithAnimes> getAnimes();

    }
}
