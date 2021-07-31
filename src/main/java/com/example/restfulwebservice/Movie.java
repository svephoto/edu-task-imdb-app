package com.example.restfulwebservice;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "movies")
public class Movie {
    private String name;
    private Date year;
    private double rating;
//    private String actors;
    private List<String> actors;
    private String genre;
    private byte[] image;
    private String trailer;

    public Movie() {
    }

//    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYear() {
        return this.year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

//    @ManyToOne(cascade = CascadeType.ALL)
    public List<String> getActors() {
        return this.actors;
    }

    public void setActors(List<String> act) {
        this.actors = act;
    }

//    public String getActors() {
//        return this.actors;
//    }
//
//    public void setActors(String actors) {
//        this.actors = actors;
//    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
