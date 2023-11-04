package trainual.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainual.userservice.dto.FeedbackDto;
import trainual.userservice.dto.FeedbackRequestDto;
import trainual.userservice.mapper.FeedbackMapper;
import trainual.userservice.repository.FeedbackRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    FeedbackMapper feedbackMapper;

    public List<FeedbackDto> getUserFeedbacks(String userId) {
        return feedbackRepository.findByUserId(Long.valueOf(userId)).stream()
                .map(feedbackMapper::toFeedbackDto)
                .collect(Collectors.toList());
    }

    public FeedbackDto getFeedback(String feedbackId) {
        return feedbackMapper.toFeedbackDto(feedbackRepository.getReferenceById(Long.valueOf(feedbackId)));
    }

    public FeedbackDto saveFeedback(FeedbackRequestDto feedbackRequestDto) {
        var review = feedbackMapper.toFeedbackModel(feedbackRequestDto);
        return feedbackMapper.toFeedbackDto(feedbackRepository.saveAndFlush(review));
    }
}
