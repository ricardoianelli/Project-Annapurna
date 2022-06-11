package edu.miu.ratingservice.utils;

import java.util.ArrayList;
import java.util.List;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.dto.response.RatingResponseDTO;
import edu.miu.ratingservice.model.Rating;

public class RatingUtils {
    public static List<RatingResponseDTO> parseRatingToRatingResponseDTO(List<Rating> ratings) {
        List<RatingResponseDTO> ratingResponseDTOList = new ArrayList<>();
        for (Rating rating : ratings) {
            RatingResponseDTO ratingResponseDTO = new RatingResponseDTO();
            ratingResponseDTO.setDailyMeal(rating.getDailyMeal());
            ratingResponseDTO.setUser(rating.getUser());
            ratingResponseDTO.setRating(rating.getRating());
            ratingResponseDTOList.add(ratingResponseDTO);
        }
        return ratingResponseDTOList;
    }

    public static Rating parseRatingRequestDTOToRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = new Rating();
        rating.setDailyMeal(ratingRequestDTO.getDailyMeal());
        rating.setUser(ratingRequestDTO.getUser());
        rating.setRating(ratingRequestDTO.getRating());
        return rating;
    }

    public static RatingResponseDTO parseRatingToRatingReponseDTOObject(Rating rating) {
        RatingResponseDTO ratingResponseDTO = new RatingResponseDTO();
        ratingResponseDTO.setDailyMeal(rating.getDailyMeal());
        ratingResponseDTO.setUser(rating.getUser());
        ratingResponseDTO.setRating(rating.getRating());
        return ratingResponseDTO;
    }

}
