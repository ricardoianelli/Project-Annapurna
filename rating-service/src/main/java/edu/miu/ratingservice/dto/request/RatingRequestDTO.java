package edu.miu.ratingservice.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingRequestDTO implements Serializable {
    private String dailyMeal;
    private String user;
    private Double rating;
}
