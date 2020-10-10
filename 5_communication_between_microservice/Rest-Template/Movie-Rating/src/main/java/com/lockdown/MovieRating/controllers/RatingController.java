package com.lockdown.MovieRating.controllers;

import com.lockdown.MovieRating.models.MovieRating;
import com.lockdown.MovieRating.models.UserRatingResponse;
import com.lockdown.MovieRating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @GetMapping("/{aadharNumber}")
    public ResponseEntity<?> getMovieRatingByUserAadharNaumber(@PathVariable("aadharNumber") int aadharNumber)
    {
        List<MovieRating> movieRatingList= ratingService.getRatingByUserId(aadharNumber);
        if(movieRatingList==null)
            return new ResponseEntity<UserRatingResponse>(new UserRatingResponse(aadharNumber,null), HttpStatus.NOT_FOUND);
        return new ResponseEntity<UserRatingResponse>(new UserRatingResponse(aadharNumber,movieRatingList), HttpStatus.OK);

    }

    @PostMapping("/{aadharNumber}")
    public ResponseEntity<?> saveRating(@PathVariable("aadharNumber") int  userId, @RequestBody MovieRating movieRating)
    {
        return new ResponseEntity<MovieRating>(ratingService.save(userId,movieRating),HttpStatus.OK);
    }
}
