package edu.miu.ratingservice.utils;

import java.util.ArrayList;
import java.util.List;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.dto.response.RatingResponseDTO;
import edu.miu.ratingservice.model.Rating;

public class RatingUtils {
    public static List<RatingResponseDTO> parseRatingListToRatingResponseDTOList(List<Rating> ratings) {
        List<RatingResponseDTO> ratingResponseDTOList = new ArrayList<>();
        for (Rating rating : ratings) {
            ratingResponseDTOList.add(parseRatingToRatingResponseDTOObject(rating));
        }
        return ratingResponseDTOList;
    }

    public static Rating parseRatingRequestDTOToRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = new Rating();
        rating.setDailyMealId(ratingRequestDTO.getDailyMealId());
        rating.setUserId(ratingRequestDTO.getUserId());
        rating.setRating(ratingRequestDTO.getRating());
        return rating;
    }

    public static RatingResponseDTO parseRatingRequestDTOToRatingResponseDTO(Rating rating) {
        RatingResponseDTO ratingResponseDTO = new RatingResponseDTO();
        ratingResponseDTO.setUserId(rating.getUserId());
        ratingResponseDTO.setDailyMealId(rating.getDailyMealId());
        ratingResponseDTO.setRating(rating.getRating());
        return ratingResponseDTO;
    }

    public static RatingResponseDTO parseRatingToRatingResponseDTOObject(Rating rating) {
        RatingResponseDTO ratingResponseDTO = new RatingResponseDTO();
        ratingResponseDTO.setDailyMealId(rating.getDailyMealId());
        ratingResponseDTO.setUserId(rating.getUserId());
        ratingResponseDTO.setRating(rating.getRating());
        return ratingResponseDTO;
    }
}
