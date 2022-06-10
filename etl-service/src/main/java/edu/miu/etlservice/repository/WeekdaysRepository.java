package edu.miu.etlservice.repository;

import edu.miu.etlservice.model.Weekdays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekdaysRepository extends JpaRepository<Weekdays, Short> {
}
