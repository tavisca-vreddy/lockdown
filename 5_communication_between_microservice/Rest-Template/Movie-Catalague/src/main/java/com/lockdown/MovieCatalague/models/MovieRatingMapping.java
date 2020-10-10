package com.lockdown.MovieCatalague.models;

public class MovieRatingMapping {
    private String movieName;
    private String movieDesc;
    private int rating;

    public MovieRatingMapping(String movieName, String movieDesc, int rating, int movieId) {
        this.movieName = movieName;
        this.movieDesc = movieDesc;
        this.rating = rating;
        this.movieId = movieId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    private int movieId;

    public MovieRatingMapping() {
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
