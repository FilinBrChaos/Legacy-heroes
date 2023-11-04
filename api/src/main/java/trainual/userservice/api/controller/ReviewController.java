package trainual.userservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trainual.userservice.dto.ReviewDto;
import trainual.userservice.dto.ReviewRequestDto;
import trainual.userservice.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/review/")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ReviewDto>> getUserReviewsList(@PathVariable("userId") String userId) {
        var reviews = reviewService.getUserReviews(userId);
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ReviewDto> putReviewForUser(@RequestBody ReviewRequestDto requestDto, @PathVariable("userId") Integer userId) {
        var review = reviewService.putUserReview(requestDto, userId);
        return ResponseEntity.ok(review);
    }
}
