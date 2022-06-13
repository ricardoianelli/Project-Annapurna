package edu.miu.emailservice.services.impl;

import edu.miu.emailservice.domain.DailyMeal;
import edu.miu.emailservice.domain.DineMeals;
import edu.miu.emailservice.domain.Email;
import edu.miu.emailservice.dto.UserResponseDTO;
import edu.miu.emailservice.services.EmailCreatorService;
import org.springframework.stereotype.Service;

@Service
public class EmailCreatorServiceImpl implements EmailCreatorService {

    public Email getEmail(UserResponseDTO user, String mailBody, String weekday, String date) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h3>Hi ")
                .append(user.getName())
                .append("!")
                .append("\uD83C\uDF7D")
                .append("</h3><br><strong><u>Here's your menu for today (")
                .append(weekday)
                .append(", ")
                .append(date)
                .append("):</u></strong>")
                .append(mailBody)
                .append("<br><br><i>Please not that this information can be changed at anytime by the official meals provider!</i>");

        String email_user = System.getenv("GMAIL_USER");

        return new Email(email_user, user.getEmail(), sb.toString());
    }

    public String getBaseEmailBody(DailyMeal dailyMeal) {
        StringBuilder sb = new StringBuilder();

        for (DineMeals dineMeals : dailyMeal.getDayDines()) {
            sb.append("<br><br><b>").append(dineMeals.getDineType()).append("</b>");
            for (String mealName : dineMeals.getMealNames()) {
                sb.append("<br>- ").append(mealName);
            }
        }

        return sb.toString();
    }
}
