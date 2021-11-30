package com.bryan.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.UUID;

@Entity
//corresponde a :
@Table(name="anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID animeid;

    public String text;
    public String description;
    public String type;
    public int year;
    public String image;

    /*@ManyToMany(mappedBy = "authors")
    public Set<Anime> animes;

    @ManyToMany
    @JoinTable (name= "anime_author", joinColumns = @JoinColumn(name = "animeid"),inverseJoinColumns = @JoinColumn(name = "authorid"))
    public Set<Author> authors;

    public interface  ProjectionAuthorWithAnimes{
        UUID getAuthorid();
        String getName();
        @JsonIgnoreProperties("actors")
        Set<ProjectionAuthorWithAnimes> getMovies();
    }*/

    public UUID getAnimeid() {
        return animeid;
    }

    public void setAnimeid(UUID animeid) {
        this.animeid = animeid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
