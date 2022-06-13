package edu.miu.ratingservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Rating implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String dailyMealId;
    private String userId;

    private Double rating;

    public Rating() {
    }

    public Rating(String dailyMeal, String user, Double rating) {
        this.dailyMealId = dailyMeal;
        this.userId = user;
        this.rating = rating;
    }

}
