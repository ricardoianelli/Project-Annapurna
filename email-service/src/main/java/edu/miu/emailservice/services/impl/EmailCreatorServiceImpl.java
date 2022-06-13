package edu.miu.emailservice.services.impl;

import edu.miu.emailservice.domain.DailyMeal;
import edu.miu.emailservice.domain.DineMeals;
import edu.miu.emailservice.domain.Email;
import edu.miu.emailservice.dto.UserResponseDTO;
import edu.miu.emailservice.services.EmailCreatorService;
import org.springframework.stereotype.Service;

@Service
public class EmailCreatorServiceImpl implements EmailCreatorService {
    private final String FROM_EMAIL = "dinningsubscription@ricardoianelli.com";

    public Email getEmail(UserResponseDTO user, String mailBody, String weekday, String date) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hi ")
                .append(user.getName())
                .append("!\nHere's your menu for today (")
                .append(weekday)
                .append(", ")
                .append(date)
                .append("):")
                .append(mailBody)
                .append("\n\nPlease not that this information can be changed at anytime by the official meals provider!");

        return new Email(FROM_EMAIL, user.getEmail(), sb.toString());
    }

    public String getBaseEmailBody(DailyMeal dailyMeal) {
        StringBuilder sb = new StringBuilder();

        for (DineMeals dineMeals : dailyMeal.getDayDines()) {
            sb.append("\n\n").append(dineMeals.getDineType());
            for (String mealName : dineMeals.getMealNames()) {
                sb.append("\n- ").append(mealName);
            }
        }

        return sb.toString();
    }
}
