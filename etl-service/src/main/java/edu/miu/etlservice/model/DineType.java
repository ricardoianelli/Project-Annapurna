package edu.miu.etlservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//Probably should be an enum or abstract sealed class only with constants
@Entity
@Data
public class DineType implements Serializable {

    public static final String BREAKFAST =  "Breakfast";
    public static final String BRUNCH =  "Brunch";
    public static final String LUNCH =  "Lunch";
    public static final String DINNER =  "Dinner";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

    public DineType() {
    }

    public DineType(String name) {
        this.name = name;
    }
}
