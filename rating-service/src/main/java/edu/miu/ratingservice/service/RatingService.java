package edu.miu.ratingservice.service;

import java.util.List;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.dto.response.RatingResponseDTO;
import edu.miu.ratingservice.model.Rating;

public interface RatingService {
    List<Rating> getRatingByDailyMealId(Long id);

    List<Rating> getRatingByUserId(Long id);

    RatingResponseDTO getRatingById(Long id);

    RatingResponseDTO addRating(RatingRequestDTO ratingRequestDTO);

    RatingResponseDTO updateRating(RatingRequestDTO ratingRequestDTO, Long id);

    RatingResponseDTO deleteRating(Long id);
}
