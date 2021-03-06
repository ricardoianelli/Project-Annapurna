package edu.miu.ratingservice.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingRequestDTO implements Serializable {
    private Long dailyMealId;
    private Long userId;
    private Double rating;
}
