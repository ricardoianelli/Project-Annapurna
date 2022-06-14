package edu.miu.ratingservice.repository;

import edu.miu.ratingservice.model.Rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("SELECT r FROM Rating r WHERE r.userId = :id")
    List<Rating> findByUserId(Long id);

    @Query("SELECT r FROM Rating r WHERE r.dailyMealId= :id")
    List<Rating> findByDailyMealId(Long id);
}
