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
    private String dailyMeal;
    private String user;

    private Double rating;

    public Rating() {

    }

    public Rating(String dailyMeal, String user, Double rating) {
        this.dailyMeal = dailyMeal;
        this.user = user;
        this.rating = rating;
    }

}
