package edu.miu.ratingservice.service;

import java.util.List;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.dto.response.RatingResponseDTO;

public interface RatingService {
    // List<RatingResponseDTO> getRatingsByMeal(Long id);

    // List<RatingResponseDTO> getRatingsByDay();

    // List<RatingResponseDTO> getRatingsByUser(Long id);

    RatingResponseDTO getRatingById(Long id);

    String addRating(RatingRequestDTO ratingRequestDTO);

    RatingResponseDTO updateRating(RatingRequestDTO ratingRequestDTO, Long id);

    String deleteRating(Long id);
}
