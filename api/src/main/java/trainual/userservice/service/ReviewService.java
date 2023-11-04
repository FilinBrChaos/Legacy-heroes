package trainual.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainual.userservice.dto.ReviewDto;
import trainual.userservice.dto.ReviewRequestDto;
import trainual.userservice.mapper.ReviewMapper;
import trainual.userservice.repository.ReviewRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ReviewMapper reviewMapper;

    public List<ReviewDto> getUserReviews(String userId) {
        return reviewRepository.findByUserId(Long.valueOf(userId)).stream()
                .map(reviewMapper::toReviewDto)
                .collect(Collectors.toList());
    }

    public ReviewDto putUserReview(ReviewRequestDto reviewRequestDto, Integer userId) {
        var review = reviewMapper.toReviewModel(reviewRequestDto, userId);
        return reviewMapper.toReviewDto(reviewRepository.saveAndFlush(review));
    }
}
