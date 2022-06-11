package edu.miu.ratingservice.repository;

import edu.miu.ratingservice.model.DineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DineTypeRepository extends JpaRepository<DineType, Long> {
    DineType getDineTypeByName(String name);
}
