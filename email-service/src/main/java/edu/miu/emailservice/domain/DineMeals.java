package edu.miu.emailservice.domain;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class DineMeals {
    private List<String> mealNames;
    @NotBlank
    private String dineType;

    public DineMeals(List<String> mealNames, String dineType) {
        this.mealNames = mealNames;
        this.dineType = dineType;
    }
}
