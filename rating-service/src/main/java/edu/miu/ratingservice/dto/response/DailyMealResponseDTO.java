package edu.miu.ratingservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyMealResponseDTO {
    private String meal;
    private String weekDay;
    private String dineType;
    private String date;
}
