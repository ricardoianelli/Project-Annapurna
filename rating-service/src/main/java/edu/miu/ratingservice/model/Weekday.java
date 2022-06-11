package edu.miu.ratingservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Weekday implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String weekday;

    public Weekday() {

    }

    public Weekday(String weekday) {
        this.weekday = weekday;
    }
}
