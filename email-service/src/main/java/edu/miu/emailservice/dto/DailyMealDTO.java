package edu.miu.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyMealDTO {
    private String meal;
    private String weekDay;
    private String dineType;
    private String date;
}
