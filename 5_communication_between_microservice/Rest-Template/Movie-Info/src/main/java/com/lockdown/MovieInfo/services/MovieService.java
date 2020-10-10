package com.lockdown.MovieInfo.services;

import com.lockdown.MovieInfo.models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private List<Movie> movies =new ArrayList<Movie>()
    {
        {
            add(new Movie(1, "Khaidhi", "Emotional Father Daughter moie"));
            add(new Movie(2, "nishabdham", "thriller Crime"));
            add(new Movie(3, "prema kavali", "love story"));
        }
    };
    public Movie getByMovieId(int movieId) {
        return movies.stream()
                .filter(movie -> movie.getId()==movieId)
                .findFirst()
                .orElse(null);
    }

    public Movie save(Movie movie) {

            int id=getMaxId();
            id++;
            movie.setId(id);
            movies.add(movie);
       return movie;
    }

    private int getMaxId() {

        return movies.stream().map(m->m.getId()).sorted().skip(movies.size()-1).findFirst().orElse(0);
    }
}
