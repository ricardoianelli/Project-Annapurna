package edu.miu.ratingservice.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingResponseDTO implements Serializable {
    private String dailyMealId;
    private String userId;
    private Double rating;
}
