package edu.miu.ratingservice.repository;

import edu.miu.ratingservice.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal getMealByName(String name);
}
