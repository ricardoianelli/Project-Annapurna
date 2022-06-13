package edu.miu.etlservice.helpers;

import edu.miu.etlservice.dto.DailyMealDTO;
import edu.miu.etlservice.model.DailyMeal;

public class DailyMealMapper {

    public static DailyMeal toEntity(DailyMealDTO dailyMealDTO) {
        //TODO
        return new DailyMeal();
    }

    public static DailyMealDTO toDTO(DailyMeal dailyMeal) {
        DailyMealDTO dto = new DailyMealDTO();
        dto.setMeal(dailyMeal.getMeal().getName());
        dto.setWeekDay(dailyMeal.getWeekday().getName());
        dto.setDineType(dailyMeal.getDineType().getName());
        dto.setDate(dailyMeal.getDate().toString());

        return dto;
    }
}
