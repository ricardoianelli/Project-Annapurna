package edu.miu.emailservice.services;

import edu.miu.emailservice.domain.DailyMeal;
import edu.miu.emailservice.domain.Email;
import edu.miu.emailservice.domain.User;

import java.util.List;

public interface EmailCreatorService {
    Email create(User user, DailyMeal dailyMeal);
}
