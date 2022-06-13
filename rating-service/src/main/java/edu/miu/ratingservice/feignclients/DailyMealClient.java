package edu.miu.ratingservice.feignclients;

import edu.miu.ratingservice.dto.response.DailyMealResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "etl-service")
@Service
public interface DailyMealClient {
    @GetMapping("/api/v1/etl/dailymeal")
    DailyMealResponseDTO getDailyMealById(Long id);
}
