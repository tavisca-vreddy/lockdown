package com.lockdown.moviecatalague.controllers;

import com.lockdown.moviecatalague.models.MovieRatingMapping;
import com.lockdown.moviecatalague.models.RatingResponse;
import com.lockdown.moviecatalague.models.movieInfoService.Movie;
import com.lockdown.moviecatalague.models.ratingService.MovieRating;
import com.lockdown.moviecatalague.models.ratingService.UserRatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movieCatalague")
public class MovieCatalagueController {
    @Autowired
    private WebClient.Builder webClientBuilder;
    @GetMapping("/{userId}")
    public ResponseEntity<?> getMovieRatingsByUserId(@PathVariable int userId)
    {
        //getting movieid's rated by user using userId
       UserRatingResponse ratingSrviceReponse=webClientBuilder.build()
                                                   .get()
                                                   .uri("http://localhost:8088/ratings/"+userId)
                                                   .retrieve()
                                                   .bodyToMono(UserRatingResponse.class)
                                                   .block();

        List<MovieRating> movieRatingList=ratingSrviceReponse.getMovieRatingList();

        //getting movie descriptions
        List<MovieRatingMapping> mapping=movieRatingList.stream().map(movieRating -> {
            Movie movie=webClientBuilder.build()
                                        .get()
                                        .uri("http://localhost:8089/movies/"+movieRating.getMovieId())
                                        .retrieve()
                                        .bodyToMono(Movie.class)
                                        .block();// block method waits excution here untill response comes..shortly it makes syncronous
            return new MovieRatingMapping(movie.getName(),movie.getDescription(),movieRating.getRating(),movie.getId());
        }).collect(Collectors.toList());
        RatingResponse response=new RatingResponse(mapping);
        return new ResponseEntity<RatingResponse>(response, HttpStatus.OK);
    }

//    @PostMapping("/{userId}")
//    public ResponseEntity<?> getMovieRatingsByUserId(@PathVariable int userId,@RequestBody MovieRating movieRating)
//    {
//        //check moive id is present or not
//        try {
//            restTemplateClient.getForEntity("http://movie-info-service/movies/" + movieRating.getMovieId(), Movie.class);
//        }catch (HttpClientErrorException e)
//        {
//            if(e.getStatusCode()==HttpStatus.NOT_FOUND)
//                return new ResponseEntity<String>("required movie is not yet added",HttpStatus.OK);
//        }
//
//        //if movieid present  insert into rating service
//        restTemplateClient.postForObject("http://movie-rating-service/ratings/"+userId,movieRating,MovieRating.class);
//        return new ResponseEntity<MovieRating>(movieRating,HttpStatus.OK);
//    }
}
