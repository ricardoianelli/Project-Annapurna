package edu.miu.ratingservice.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.dto.response.RatingResponseDTO;
import edu.miu.ratingservice.model.Rating;
import edu.miu.ratingservice.repository.DailyMealRepository;
import edu.miu.ratingservice.repository.DineTypeRepository;
import edu.miu.ratingservice.repository.MealRepository;
import edu.miu.ratingservice.repository.RatingRepository;
import edu.miu.ratingservice.repository.UserRepository;
import edu.miu.ratingservice.repository.WeekdaysRepository;
import edu.miu.ratingservice.service.RatingService;
import edu.miu.ratingservice.utils.RatingUtils;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    private final DailyMealRepository dailyMealRepository;
    private final DineTypeRepository dineTypeRepository;
    private final MealRepository mealRepository;
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final WeekdaysRepository weekdaysRepository;

    public RatingServiceImpl(DailyMealRepository dailyMealRepository, DineTypeRepository dineTypeRepository,
            MealRepository mealRepository, RatingRepository ratingRepository, UserRepository userRepository,
            WeekdaysRepository weekdaysRepository) {
        this.dailyMealRepository = dailyMealRepository;
        this.dineTypeRepository = dineTypeRepository;
        this.mealRepository = mealRepository;
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.weekdaysRepository = weekdaysRepository;
    }

    @Override
    public List<RatingResponseDTO> getRatingsByMeal(Long id) {

        return null;
    }

    @Override
    public List<RatingResponseDTO> getRatingsByDay() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RatingResponseDTO> getRatingsByUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RatingResponseDTO getRatingById(Long id) {
        Rating rating = ratingRepository.findById(id).get();
        return RatingUtils.parseRatingToRatingReponseDTOObject(rating);
    }

    @Override
    public RatingRequestDTO addRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = RatingUtils.parseRatingRequestDTOToRating(ratingRequestDTO);
        rating = ratingRepository.save(rating);
    }

    @Override
    public RatingResponseDTO updateRating(RatingResponseDTO ratingResponseDTO, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RatingResponseDTO addRating(RatingResponseDTO ratingResponseDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteRating(Long id) {
        // TODO Auto-generated method stub

    }
}
