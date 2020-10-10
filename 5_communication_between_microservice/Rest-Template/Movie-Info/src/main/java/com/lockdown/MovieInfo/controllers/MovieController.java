package com.lockdown.MovieInfo.controllers;

import com.lockdown.MovieInfo.models.Movie;
import com.lockdown.MovieInfo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{movieId}")
    public ResponseEntity<?> getByMovieId(@PathVariable("movieId") int movieId)
    {

        Movie movie= movieService.getByMovieId(movieId);
        if(movie==null)
            return new ResponseEntity<Movie>(new Movie(), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie)
    {
        return new ResponseEntity<Movie>(movieService.save(movie),HttpStatus.OK);
    }

}
