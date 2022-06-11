package edu.miu.ratingservice.repository;

import edu.miu.ratingservice.model.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Long> {
}
