package edu.miu.ratingservice.service;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.dto.response.RatingResponseDTO;

public interface RatingService {
    RatingResponseDTO getRatingById(Long id);

    String addRating(RatingRequestDTO ratingRequestDTO);

    RatingResponseDTO updateRating(RatingRequestDTO ratingRequestDTO, Long id);

    String deleteRating(Long id);
}
