package com.lockdown.MovieRating.services;

import com.lockdown.MovieRating.models.MovieRating;
import com.lockdown.MovieRating.models.UserRatingResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatingService {
    private Map<Integer, List<MovieRating>> userRatedMovies=new HashMap<Integer, List<MovieRating>>()
    {
        {
            put(100,new ArrayList<MovieRating>()
            {{
                add(new MovieRating(1,7));
                add(new MovieRating(2,8));
            }});
        }
    };


    public List<MovieRating> getRatingByUserId(int aadharnumber) {
        return  userRatedMovies.get(aadharnumber);
    }

    public MovieRating save(int userId, MovieRating movieRating) {
        List<MovieRating> movieRatingList=userRatedMovies.get(userId);
        if(movieRatingList==null)
            userRatedMovies.put(userId,new ArrayList<MovieRating>(){{add(movieRating);}});
        else
            movieRatingList.add(movieRating);
        return movieRating;
    }
}
