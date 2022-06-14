package edu.miu.etlservice.service;

import edu.miu.etlservice.dto.DailyMealDTO;

import java.util.List;

public interface EtlService {
    void fetch();

    List<DailyMealDTO> getDailyMeals();
}
