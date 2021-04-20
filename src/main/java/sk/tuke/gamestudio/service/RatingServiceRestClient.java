package sk.tuke.gamestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.entity.Rating;

public class RatingServiceRestClient implements RatingService{

    private final String url = "http://localhost:8080/api/rating";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public void setRating(Rating rating) {
        restTemplate.postForEntity(url,rating,Rating.class);
    }

    @Override
    public double getAverageRating(String game) {
        return restTemplate.getForEntity(url + "/" + game, Double.class ).getBody();
    }

    @Override
    public int getRating(String game, String player) {
        return restTemplate.getForEntity(url + "/" + game + "/" + player,Integer.class).getBody();
    }

    @Override
    public void reset() {

    }
}
