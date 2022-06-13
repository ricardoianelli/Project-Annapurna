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
    private Long dailyMealId;
    private Long userId;

    private Double rating;

    public Rating() {
    }

    public Rating(Long dailyMealId, Long userId, Double rating) {
        this.dailyMealId = dailyMealId;
        this.userId = userId;
        this.rating = rating;
    }

}
