package edu.miu.ratingservice.service.impl;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.dto.response.DailyMealResponseDTO;
import edu.miu.ratingservice.dto.response.RatingResponseDTO;
import edu.miu.ratingservice.dto.response.UserResponseDTO;
import edu.miu.ratingservice.exception.MealNotFoundException;
import edu.miu.ratingservice.exception.RatingNotFound;
import edu.miu.ratingservice.exception.UserNotFoundException;
import edu.miu.ratingservice.feignclients.DailyMealClient;
import edu.miu.ratingservice.feignclients.UserClient;
import edu.miu.ratingservice.model.Rating;
import edu.miu.ratingservice.repository.RatingRepository;
import edu.miu.ratingservice.service.RatingService;
import edu.miu.ratingservice.utils.RatingUtils;
import feign.FeignException;
import feign.FeignException.FeignClientException;
import feign.FeignException.NotFound;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final UserClient userClient;
    private final DailyMealClient dailyMealClient;

    public RatingServiceImpl(RatingRepository ratingRepository, UserClient userClient,
            DailyMealClient dailyMealClient) {
        this.ratingRepository = ratingRepository;
        this.userClient = userClient;
        this.dailyMealClient = dailyMealClient;
    }

    @Override
    public RatingResponseDTO getRatingById(Long id) throws RatingNotFound {
        try {
            Rating rating = ratingRepository.findById(id).get();
            return RatingUtils.parseRatingToRatingResponseDTOObject(rating);
        } catch (NoSuchElementException ex) {
            throw new RatingNotFound();
        }
    }

    @Override
    public RatingResponseDTO addRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = RatingUtils.parseRatingRequestDTOToRating(ratingRequestDTO);
        checkUserExists(rating.getUserId());
        checkMealExists(rating.getDailyMealId());
        rating = ratingRepository.save(rating);
        return RatingUtils.parseRatingToRatingResponseDTOObject(rating);
    }

    @Override
    public RatingResponseDTO updateRating(RatingRequestDTO ratingRequestDTO, Long id) throws RatingNotFound {
        try {
            Rating rating = ratingRepository.findById(id).get();
            rating = RatingUtils.parseRatingRequestDTOToRating(ratingRequestDTO);
            rating.setId(id);
            rating.setDailyMealId(ratingRepository.findById(id).get().getDailyMealId());
            rating.setUserId(ratingRepository.findById(id).get().getDailyMealId());
            rating.setRating(ratingRequestDTO.getRating());
            ratingRepository.save(rating);
            return RatingUtils.parseRatingRequestDTOToRatingResponseDTO(ratingRequestDTO);
        } catch (NoSuchElementException e) {
            throw new RatingNotFound();
        }
    }

    @Override
    public RatingResponseDTO deleteRating(Long id) throws RatingNotFound {
        try {
            Rating rating = ratingRepository.findById(id).get();
            ratingRepository.delete(rating);
            return RatingUtils.parseRatingToRatingResponseDTOObject(rating);
        } catch (NoSuchElementException e) {
            throw new RatingNotFound();
        }
    }

    private void checkUserExists(Long id) {
        try {
            userClient.getUserById(id);
        } catch (FeignException.NotFound ex) {
            throw new UserNotFoundException();
        }
    }

    private void checkMealExists(Long id) {
        try {
            dailyMealClient.getDailyMealById(id);
        } catch (FeignException.NotFound ex) {
            throw new MealNotFoundException();
        }
    }
}
