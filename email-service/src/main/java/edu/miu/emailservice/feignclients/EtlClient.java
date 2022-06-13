package edu.miu.emailservice.feignclients;

import edu.miu.emailservice.dto.DailyMealDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name="etl-service")
@Service
public interface EtlClient {
    @GetMapping("/api/v1/etl/dailymeal")
    List<DailyMealDTO> getDailyMeals(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);
}
