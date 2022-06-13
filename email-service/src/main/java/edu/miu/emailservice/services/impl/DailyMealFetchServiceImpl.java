package edu.miu.emailservice.services.impl;

import edu.miu.emailservice.domain.DailyMeal;
import edu.miu.emailservice.domain.DineMeals;
import edu.miu.emailservice.dto.DailyMealDTO;
import edu.miu.emailservice.exceptions.NoDailyMealsException;
import edu.miu.emailservice.feignclients.EtlClient;
import edu.miu.emailservice.helpers.RequestHelper;
import edu.miu.emailservice.services.DailyMealFetchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyMealFetchServiceImpl implements DailyMealFetchService {
    private final EtlClient etlClient;

    public DailyMealFetchServiceImpl(EtlClient etlClient) {
        this.etlClient = etlClient;
    }

    private DailyMeal getFormattedDailyMeal(List<DailyMealDTO> dtoList) {
        DailyMeal dailyMeal = new DailyMeal();
        DineMeals breakfastMeals = new DineMeals("Breakfast");
        DineMeals brunchMeals = new DineMeals("Brunch");
        DineMeals lunchMeals = new DineMeals("Lunch");
        DineMeals dinnerMeals = new DineMeals("Dinner");

        DailyMealDTO firstMeal = dtoList.get(0);
        dailyMeal.setWeekday(firstMeal.getWeekDay());
        dailyMeal.setDate(firstMeal.getDate());

        for (DailyMealDTO meal : dtoList) {
            String mealName = meal.getMeal();
            String dineType = meal.getDineType();
            switch (dineType) {
                case "Breakfast": breakfastMeals.addMeal(mealName);
                case "Brunch": brunchMeals.addMeal(mealName);
                case "Lunch": lunchMeals.addMeal(mealName);
                case "Dinner": dinnerMeals.addMeal(mealName);
            }
        }

        dailyMeal.addDayDine(breakfastMeals);
        dailyMeal.addDayDine(brunchMeals);
        dailyMeal.addDayDine(lunchMeals);
        dailyMeal.addDayDine(dinnerMeals);

        return dailyMeal;
    }

    @Override
    public DailyMeal getDailyMeals() {
        String token = RequestHelper.getAuthenticationToken();
        List<DailyMealDTO> dailyMealsDTO = etlClient.getDailyMeals(token);
        if (dailyMealsDTO.isEmpty()) {
            throw new NoDailyMealsException("There isn't any daily meal to create the emails.");
        }
        return getFormattedDailyMeal(dailyMealsDTO);
    }
}
