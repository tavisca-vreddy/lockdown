package com.lockdown.moviecatalague.models.ratingService;

public class MovieRating {
    public MovieRating(int movieId, int rating) {

        this.movieId = movieId;
        this.rating = rating;
    }

    public MovieRating() {
    }

    private int movieId;
    private int rating;



    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
