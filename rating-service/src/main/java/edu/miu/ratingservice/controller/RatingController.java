package edu.miu.ratingservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.ratingservice.dto.request.RatingRequestDTO;
import edu.miu.ratingservice.service.RatingService;
import feign.Response;

import static edu.miu.ratingservice.constant.WebResourceKeyConstant.ALL;
import static edu.miu.ratingservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.ratingservice.constant.WebResourceKeyConstant.RatingConstants.RATING_BASE;

@RestController
@RequestMapping(value = API_V1 + RATING_BASE)
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // // list
    // @GetMapping("/meal/{id}")
    // public ResponseEntity<?> getRatingsByMeal(Long id) {
    // return null;
    // }

    // // list return type
    // @GetMapping
    // public ResponseEntity<?> getRatingsByDay() {
    // return null;
    // }

    // // List return type
    // @GetMapping("/user/rating/{id}")
    // public ResponseEntity<?> getRatingsByUser(Long id) {
    // return null;
    // }

    // String return type
    @GetMapping("/{id}")
    public ResponseEntity<?> getRatingById(@PathVariable Long id) {
        return new ResponseEntity<>(ratingService.getRatingById(id),
                HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<?> addNewMealRating(@RequestBody RatingRequestDTO ratingRequestDTO) {
        return new ResponseEntity<>(ratingService.addRating(ratingRequestDTO),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRating(@PathVariable Long id, @RequestBody RatingRequestDTO ratingRequestDTO) {
        return new ResponseEntity<>(ratingService.updateRating(ratingRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRating(@PathVariable Long id) {
        return new ResponseEntity<>(ratingService.deleteRating(id), HttpStatus.OK);
    }
}
