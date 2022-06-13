package edu.miu.etlservice.controller;

import edu.miu.etlservice.dto.DailyMealDTO;
import edu.miu.etlservice.service.impl.EtlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static edu.miu.etlservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.etlservice.constant.WebResourceKeyConstant.UserConstants.ETL_BASE;

@RestController
@RequestMapping(value = API_V1 + ETL_BASE)
public class EtlController {

    private final EtlService etlService;

    public EtlController(EtlService etlService) {
        this.etlService = etlService;
    }

    @PostMapping("/fetch")
    public ResponseEntity<?> fetch() {
        etlService.fetch();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("dailymeal")
    public ResponseEntity<?> getDailyMeals() {
        List<DailyMealDTO> dailyMeal = etlService.getDailyMeals();
        if (dailyMeal.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(dailyMeal, HttpStatus.OK);
    }

    @GetMapping("dailymeal/{id}")
    public ResponseEntity<?> getDailyMealById(@PathVariable Long id) {
        DailyMealDTO dailyMeal = etlService.getDailyMealById(id);
        return new ResponseEntity<>(dailyMeal, HttpStatus.OK);
    }

}
