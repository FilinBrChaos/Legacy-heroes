package trainual.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainual.userservice.dto.FeedbackDto;
import trainual.userservice.dto.FeedbackRequestDto;
import trainual.userservice.mapper.FeedbackMapper;
import trainual.userservice.repository.FeedbackRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private BadgeService badgeService;
    @Autowired
    private UserService userService;

    public List<FeedbackDto> getUserFeedbacks(String userId) {
        return feedbackRepository.findByUserId(Long.valueOf(userId)).stream()
                .map(feedback -> feedbackMapper.toFeedbackDto(feedback, getBadgeUrl(feedback.getBadgeId())))
                .collect(Collectors.toList());
    }

    public FeedbackDto getFeedback(String feedbackId) {
        var feedback = feedbackRepository.getReferenceById(Long.valueOf(feedbackId));
        return feedbackMapper.toFeedbackDto(feedback, getBadgeUrl(feedback.getBadgeId()));
    }

    public FeedbackDto saveFeedback(FeedbackRequestDto feedbackRequestDto) throws IOException {
        var feedbackModel = feedbackMapper.toFeedbackModel(feedbackRequestDto);
        var feedback = feedbackMapper.toFeedbackDto(feedbackRepository.saveAndFlush(feedbackModel),
                getBadgeUrl(feedbackModel.getBadgeId()));
        userService.saveNewUserIfNotExist(feedback.getUserId());
        userService.updateUserNickname(getFeedbacksAsList(feedback.getUserId().toString()), feedback.getUserId());
        userService.addRewardPoints(feedback.getUserId(), feedback.getRewardPoints());
        return feedback;
    }

    private List<String> getFeedbacksAsList(String userId) {
        return getUserFeedbacks(userId)
                .stream().map(FeedbackDto::getComment)
                .collect(Collectors.toList());
    }

    private String getBadgeUrl(Long badgeId) {
        return badgeService.getBadgeUrl(badgeId);
    }
}
