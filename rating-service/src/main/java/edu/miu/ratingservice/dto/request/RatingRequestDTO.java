package edu.miu.ratingservice.dto.request;

import java.io.Serializable;

import edu.miu.ratingservice.model.DailyMeal;
import edu.miu.ratingservice.model.User;
import lombok.Data;

@Data
public class RatingRequestDTO implements Serializable {
    private DailyMeal dailyMeal;
    private User user;
    private Double rating;
}
