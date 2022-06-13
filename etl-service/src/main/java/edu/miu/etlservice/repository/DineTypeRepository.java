package edu.miu.etlservice.repository;

import edu.miu.etlservice.model.DineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DineTypeRepository extends JpaRepository<DineType, Short> {
    DineType getDineTypeByName(String name);
}
