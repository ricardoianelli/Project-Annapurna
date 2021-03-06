package edu.miu.ratingservice.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingResponseDTO implements Serializable {
    private Long dailyMealId;
    private Long userId;
    private Double rating;
}
