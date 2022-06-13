package edu.miu.ratingservice.service.impl;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.dto.response.RatingResponseDTO;
import edu.miu.ratingservice.model.Rating;
import edu.miu.ratingservice.repository.RatingRepository;
import edu.miu.ratingservice.service.RatingService;
import edu.miu.ratingservice.utils.RatingUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RatingResponseDTO getRatingById(Long id) {
        Rating rating = ratingRepository.findById(id).get();
        return RatingUtils.parseRatingToRatingResponseDTOObject(rating);
    }

    @Override
    public String addRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = RatingUtils.parseRatingRequestDTOToRating(ratingRequestDTO);
        rating = ratingRepository.save(rating);
        return "Rating Added";
    }

    @Override
    public RatingResponseDTO updateRating(RatingRequestDTO ratingRequestDTO, Long id) {
        Rating rating = ratingRepository.findById(id).get();
        rating = RatingUtils.parseRatingRequestDTOToRating(ratingRequestDTO);
        rating.setId(id);
        rating.setDailyMeal(ratingRequestDTO.getDailyMeal());
        rating.setUser(ratingRequestDTO.getUser());
        rating.setRating(ratingRequestDTO.getRating());
        ratingRepository.save(rating);
        return RatingUtils.parseRatingRequestDTOToRatingResponseDTO(ratingRequestDTO, id);
    }

    @Override
    public String deleteRating(Long id) {
        Rating rating = ratingRepository.findById(id).get();
        ratingRepository.delete(rating);
        return "Rating Deleted";
    }
}
