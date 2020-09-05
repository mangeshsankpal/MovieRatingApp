# MovieRatingApp
Micro-services based movie rating app .

Implemented micro-services concept to develop a movie rating app with fault-tolerant feature using circuit-breaker pattern through Spring-Hystrix,
in which micro-services are registered with movie-server(Eureka Server), and other services acts as Eureka Client.

In this app, movie-catalog service(Eureka client) calls to 2 other micro-services (movie-info-service and rating-data-services) to get rated movies of specific user.
