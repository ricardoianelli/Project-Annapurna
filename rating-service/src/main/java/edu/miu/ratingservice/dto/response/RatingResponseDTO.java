package edu.miu.ratingservice.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingResponseDTO implements Serializable {
    private String dailyMeal;
    private String user;
    private Double rating;
}
