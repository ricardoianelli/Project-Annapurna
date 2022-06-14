package edu.miu.etlservice.repository;

import edu.miu.etlservice.model.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Long> {
    List<DailyMeal> findDailyMealsByDate(LocalDate date);

    DailyMeal findDailyMealById(Long id);
}
