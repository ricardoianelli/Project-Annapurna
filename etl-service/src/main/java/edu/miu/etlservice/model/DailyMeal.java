package edu.miu.etlservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class DailyMeal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Meal meal;

    @ManyToOne
    private Weekday weekday;

    @ManyToOne
    private DineType dineType;

    private LocalDate date;

    public DailyMeal() {
    }

    public DailyMeal(Meal meal, Weekday weekday, DineType dineType, LocalDate date) {
        this.meal = meal;
        this.weekday = weekday;
        this.dineType = dineType;
        this.date = date;
    }
}
