package edu.miu.ratingservice.repository;

import edu.miu.ratingservice.model.Weekday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekdaysRepository extends JpaRepository<Weekday, Short> {
}
