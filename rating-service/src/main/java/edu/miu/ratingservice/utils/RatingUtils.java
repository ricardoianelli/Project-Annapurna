package edu.miu.ratingservice.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // public static List<Object> parseRatingByMealIdToList(List<Rating> rating) {
    // List<Object> nuList = new ArrayList<Object>();
    // for (Rating rate : rating) {
    // nuList.add(rate.getUserId());
    // nuList.add(rate.getRating());
    // }
    // return nuList;
    // }

    public static List parseRatingByMealIdToList(List<Rating> rating) {
        List map = new ArrayList<Object>();
        for (Rating rating2 : rating) {
            System.out.println(rating2);
        }
        for (Rating rate : rating) {
            Map<String, Object> tempMap = new HashMap<>();
            tempMap.put("rating", rate.getRating());
            tempMap.put("userId", rate.getUserId());
            map.add(tempMap);
        }
        return map;
    }
}
