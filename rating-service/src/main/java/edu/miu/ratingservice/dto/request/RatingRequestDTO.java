package edu.miu.ratingservice.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingRequestDTO implements Serializable {
    private String dailyMealId;
    private String userId;
    private Double rating;
}
