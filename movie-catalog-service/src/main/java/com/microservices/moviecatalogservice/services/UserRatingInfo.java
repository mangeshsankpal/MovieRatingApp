package com.microservices.moviecatalogservice.services;

import com.microservices.moviecatalogservice.models.Rating;
import com.microservices.moviecatalogservice.models.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackUserRatings")
    public UserRatings getUserRatings(String userId) {
        UserRatings userRatings = restTemplate.getForObject("http://ratings-data-services/ratings/user/" + userId, UserRatings.class);
        return userRatings;
    }


    public UserRatings getFallBackUserRatings(String userId) {
        UserRatings userRatings = new UserRatings();
        Rating rating = new Rating("0",0);
        userRatings.setUserRatings(Arrays.asList(rating));
        return userRatings;
    }
}
