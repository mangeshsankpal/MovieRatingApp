package com.microserivces.ratingsdataservices.resources;

import com.microserivces.ratingsdataservices.models.Rating;
import com.microserivces.ratingsdataservices.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 5);
    }

    @RequestMapping("/user/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("100", 3),
                new Rating("300", 4)
        );

        UserRatings userRatings = new UserRatings();
        userRatings.setUserRatings(ratings);
        return userRatings;

    }


}
