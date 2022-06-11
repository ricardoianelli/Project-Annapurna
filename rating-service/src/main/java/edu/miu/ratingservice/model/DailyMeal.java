package edu.miu.ratingservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class DailyMeal implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Meal meal;

    @ManyToOne
    private Weekday weekday;

    @ManyToOne
    private DineType dineType;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    public DailyMeal(Meal meal, Weekday weekday, DineType dineType, LocalDate date) {
        this.meal = meal;
        this.weekday = weekday;
        this.dineType = dineType;
        this.date = date;
    }
}
