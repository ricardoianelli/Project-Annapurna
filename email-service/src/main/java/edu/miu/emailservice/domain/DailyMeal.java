package edu.miu.emailservice.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DailyMeal {
    @NotEmpty
    private List<DineMeals> dayDines;
    @NotBlank
    private String weekday;
    @NotBlank
    private String date;

    public DailyMeal(List<DineMeals> dayDines, String weekday, String date) {
        this.dayDines = dayDines;
        this.weekday = weekday;
        this.date = date;
    }
}
