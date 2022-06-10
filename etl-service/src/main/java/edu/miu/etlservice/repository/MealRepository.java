package edu.miu.etlservice.repository;

import edu.miu.etlservice.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Short> {
    Meal getMealByName(String name);
}
