package edu.miu.etlservice.repository;

import edu.miu.etlservice.model.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Long> {
}
