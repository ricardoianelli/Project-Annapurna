package edu.miu.etlservice.repository;

import edu.miu.etlservice.model.Weekday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekdayRepository extends JpaRepository<Weekday, Short> {
}
