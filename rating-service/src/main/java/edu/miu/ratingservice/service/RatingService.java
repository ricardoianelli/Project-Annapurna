package edu.miu.ratingservice.service;

import java.util.List;

import edu.miu.ratingservice.dto.response.RatingResponseDTO;

public interface RatingService {
    List<RatingResponseDTO> getRatingsByMeal(Long id);

    List<RatingResponseDTO> getRatingsByDay();

    List<RatingResponseDTO> getRatingsByUser(Long id);

    RatingResponseDTO getRatingById(Long id);

    String addRating(RatingResponseDTO ratingResponseDTO);

    RatingResponseDTO updateRating(RatingResponseDTO ratingResponseDTO, Long id);

    void deleteRating(Long id);
}
