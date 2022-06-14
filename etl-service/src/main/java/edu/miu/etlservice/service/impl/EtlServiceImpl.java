package edu.miu.etlservice.service.impl;

import edu.miu.etlservice.dto.DailyMealDTO;
import edu.miu.etlservice.exceptions.DailyMealNotFoundException;
import edu.miu.etlservice.helpers.DailyMealMapper;
import edu.miu.etlservice.model.DailyMeal;
import edu.miu.etlservice.model.DineType;
import edu.miu.etlservice.model.Meal;
import edu.miu.etlservice.model.Weekday;
import edu.miu.etlservice.repository.DailyMealRepository;
import edu.miu.etlservice.repository.DineTypeRepository;
import edu.miu.etlservice.repository.MealRepository;
import edu.miu.etlservice.repository.WeekdayRepository;
import edu.miu.etlservice.service.EtlService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EtlServiceImpl implements EtlService {
    private final DailyMealRepository dailyMealRepository;
    private final DineTypeRepository dineTypeRepository;
    private final MealRepository mealRepository;
    private final WeekdayRepository weekdayRepository;

    public EtlServiceImpl(DailyMealRepository dailyMealRepository, DineTypeRepository dineTypeRepository, MealRepository mealRepository, WeekdayRepository weekdayRepository) {
        this.dailyMealRepository = dailyMealRepository;
        this.dineTypeRepository = dineTypeRepository;
        this.mealRepository = mealRepository;
        this.weekdayRepository = weekdayRepository;
    }

    public void fetch() {
        if (mealRepository.existsById((short)1)) return;

        populateDomainClasses(); //TODO: Remove it after we stop recreating DB
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 10; i++) {
            LocalDate currentDate = today.minusDays(i);
            getMockedDailyMeals(currentDate);
        }
    }

    public List<DailyMealDTO> getDailyMeals() {
        LocalDate today = LocalDate.now();
        List<DailyMeal> dailyMeals = dailyMealRepository.findDailyMealsByDate(today);
        return dailyMeals.stream().map((meal) -> DailyMealMapper.toDTO(meal)).collect(Collectors.toList());
    }

    @Override
    public DailyMealDTO getDailyMealById(Long id) {
        DailyMeal dailyMeal = dailyMealRepository.findDailyMealById(id);
        if (dailyMeal == null) throw new DailyMealNotFoundException();

        return DailyMealMapper.toDTO(dailyMeal);
    }

    private void populateDomainClasses() {
        populateWeekdayDomain();
        populateDineTypeDomain();
        populateMealDomain();
    }

    private void populateWeekdayDomain() {
        List<Weekday> weekDays = new ArrayList<>();
        weekDays.add(new Weekday("Sunday"));
        weekDays.add(new Weekday("Monday"));
        weekDays.add(new Weekday("Tuesday"));
        weekDays.add(new Weekday("Wednesday"));
        weekDays.add(new Weekday("Thursday"));
        weekDays.add(new Weekday("Friday"));
        weekDays.add(new Weekday("Saturday"));

        weekdayRepository.saveAll(weekDays);
    }

    private void populateDineTypeDomain() {
        List<DineType> dineTypes = new ArrayList<>();
        dineTypes.add(new DineType("Breakfast"));
        dineTypes.add(new DineType("Brunch"));
        dineTypes.add(new DineType("Lunch"));
        dineTypes.add(new DineType("Dinner"));

        dineTypeRepository.saveAll(dineTypes);
    }

    private void populateMealDomain() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Split Peas Soup"));
        meals.add(new Meal("Leafy Greens"));
        meals.add(new Meal("Oatmeal"));
        meals.add(new Meal("Breakfast Potatoes"));
        meals.add(new Meal("Tofu Scramble"));
        meals.add(new Meal("Hot Milk"));
        meals.add(new Meal("Briyani"));
        meals.add(new Meal("Basmati Rice"));
        meals.add(new Meal("Dhal"));
        meals.add(new Meal("Pizza"));

        mealRepository.saveAll(meals);
    }

    private void getMockedDailyMeals(LocalDate date) {
        final Random randomGenerator = new Random();

        generateDailyMealsByDineType(randomGenerator, DineType.BREAKFAST, date);
        generateDailyMealsByDineType(randomGenerator, DineType.LUNCH, date);
        generateDailyMealsByDineType(randomGenerator, DineType.BRUNCH, date);

    }

    private void generateDailyMealsByDineType(Random randomGenerator, String dineTypeName, LocalDate date) {
        final int mealsCount = Math.max(4, randomGenerator.nextInt(10));
        final short weekDay = (short) Math.max(1, randomGenerator.nextInt(7));

        DineType dineType = dineTypeRepository.getDineTypeByName(dineTypeName);
        List<DailyMeal> dailyMeals = new ArrayList<>();

        final long lastMealId = mealRepository.count();
        Random random = new Random();

        for (int i = 0; i < mealsCount; i++) {
            short currentMealId = (short) Math.max(1, random.nextInt((int) lastMealId));
            Meal meal = mealRepository.findById(currentMealId).get();
            Weekday weekday = weekdayRepository.findById(weekDay).get();
            DailyMeal dailyMeal = new DailyMeal(meal, weekday, dineType, date);
            dailyMeals.add(dailyMeal);
        }

        dailyMealRepository.saveAll(dailyMeals);
    }

}
