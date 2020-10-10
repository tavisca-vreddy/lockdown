package com.lockdown.MovieCatalague.controllers;

import com.lockdown.MovieCatalague.models.MovieRatingMapping;
import com.lockdown.MovieCatalague.models.RatingResponse;
import com.lockdown.MovieCatalague.models.movieInfoService.Movie;
import com.lockdown.MovieCatalague.models.ratingService.MovieRating;
import com.lockdown.MovieCatalague.models.ratingService.UserRatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movieCatalague")
public class MovieCatalagueController {
     @Autowired
    private RestTemplate restTemplateClient;
    @GetMapping("/{userId}")
    public ResponseEntity<?> getMovieRatingsByUserId(@PathVariable int userId)
    {
        //getting movieid's rated by user using userId
       UserRatingResponse ratingSrviceReponse=restTemplateClient.getForObject("http://localhost:8088/ratings/"+userId,UserRatingResponse.class);
        List<MovieRating> movieRatingList=ratingSrviceReponse.getMovieRatingList();

        //getting movie descriptions
        List<MovieRatingMapping> mapping=movieRatingList.stream().map(movieRating -> {
            Movie movie=restTemplateClient.getForObject("http://localhost:8089/movies/"+movieRating.getMovieId(), Movie.class);
            return new MovieRatingMapping(movie.getName(),movie.getDescription(),movieRating.getRating(),movie.getId());
        }).collect(Collectors.toList());
        RatingResponse response=new RatingResponse(mapping);
        return new ResponseEntity<RatingResponse>(response, HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> getMovieRatingsByUserId(@PathVariable int userId,@RequestBody MovieRating movieRating)
    {
        //check moive id is present or not
        try {
            restTemplateClient.getForEntity("http://localhost:8089/movies/" + movieRating.getMovieId(), Movie.class);
        }catch (HttpClientErrorException e)
        {
            if(e.getStatusCode()==HttpStatus.NOT_FOUND)
                return new ResponseEntity<String>("required movie is not yet added",HttpStatus.OK);
        }

        //if movieid present  insert into rating service
        restTemplateClient.postForObject("http://localhost:8088/ratings/"+userId,movieRating,MovieRating.class);
        return new ResponseEntity<MovieRating>(movieRating,HttpStatus.OK);
    }
}
