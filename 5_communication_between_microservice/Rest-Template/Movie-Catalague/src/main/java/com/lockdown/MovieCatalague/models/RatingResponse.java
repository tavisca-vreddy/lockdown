package com.lockdown.MovieCatalague.models;

import java.util.List;

public class RatingResponse {
    private List<MovieRatingMapping> movieRatingMappingList;

    public List<MovieRatingMapping> getMovieRatingMappingList() {
        return movieRatingMappingList;
    }

    public void setMovieRatingMappingList(List<MovieRatingMapping> movieRatingMappingList) {
        this.movieRatingMappingList = movieRatingMappingList;
    }

    public RatingResponse() {
    }

    public RatingResponse(List<MovieRatingMapping> movieRatingMappingList) {
        this.movieRatingMappingList = movieRatingMappingList;
    }
}
