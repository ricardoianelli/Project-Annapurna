package edu.miu.emailservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class DailyMeal {
    @NotEmpty
    private List<DineMeals> dayDines = new ArrayList<>();
    @NotBlank
    private String weekday;
    @NotBlank
    private String date;

    public DailyMeal(List<DineMeals> dayDines, String weekday, String date) {
        this.dayDines = dayDines;
        this.weekday = weekday;
        this.date = date;
    }

    public void addDayDine(DineMeals dine) {
        dayDines.add(dine);
    }
}
