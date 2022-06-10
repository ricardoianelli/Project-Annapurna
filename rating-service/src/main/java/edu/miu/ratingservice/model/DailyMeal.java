package edu.miu.ratingservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class DailyMeal implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Meal meal;

    @ManyToOne
    private Weekdays weekdays;

    @ManyToOne
    private DineType dineType;

    @Temporal(TemporalType.DATE)
    private Date date;
}
