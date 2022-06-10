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

    @ManyToOne
    private DailyMeal dailyMeal;

    @ManyToOne
    private User user;

}
