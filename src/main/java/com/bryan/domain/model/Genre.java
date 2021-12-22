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
    public String imageurl;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnoreProperties("genres")
    public Set<Anime> animes;


}