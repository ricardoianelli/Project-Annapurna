package edu.miu.emailservice.services;

import edu.miu.emailservice.domain.DailyMeal;
import edu.miu.emailservice.domain.Email;
import edu.miu.emailservice.dto.UserResponseDTO;

public interface EmailCreatorService {
    Email getEmail(UserResponseDTO user, String mailBody, String weekday, String date);
    String getBaseEmailBody(DailyMeal dailyMeal);
}
