package edu.miu.emailservice.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class DineMeals {
    private List<String> mealNames;
    @NotBlank
    private String dineType;

    public DineMeals(List<String> mealNames, String dineType) {
        this.mealNames = mealNames;
        this.dineType = dineType;
    }

    public DineMeals(String dineType) {
        this.mealNames = new ArrayList<>();
        this.dineType = dineType;
    }

    public void addMeal(String meal) {
        mealNames.add(meal);
    }
}
