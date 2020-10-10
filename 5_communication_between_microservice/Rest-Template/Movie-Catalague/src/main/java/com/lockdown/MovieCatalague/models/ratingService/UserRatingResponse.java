package com.lockdown.MovieCatalague.models.ratingService;

import java.util.List;

public class UserRatingResponse {
    public UserRatingResponse() {

    }

    public UserRatingResponse(int aadharNumber, List<MovieRating> movieRatingList) {
        this.aadharNumber = aadharNumber;
        this.movieRatingList = movieRatingList;
    }

    private int aadharNumber;

    public int getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public List<MovieRating> getMovieRatingList() {
        return movieRatingList;
    }

    public void setMovieRatingList(List<MovieRating> movieRatingList) {
        this.movieRatingList = movieRatingList;
    }

    private List<MovieRating> movieRatingList;
}
