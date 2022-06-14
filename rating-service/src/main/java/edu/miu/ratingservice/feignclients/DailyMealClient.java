package edu.miu.ratingservice.feignclients;

import edu.miu.ratingservice.dto.response.DailyMealResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "etl-service")
@Service
public interface DailyMealClient {
    @GetMapping("/api/v1/etl/dailymeal/{id}")
    DailyMealResponseDTO getDailyMealById(@PathVariable Long id);
}
