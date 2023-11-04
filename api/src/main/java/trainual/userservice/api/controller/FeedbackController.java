package trainual.userservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trainual.userservice.dto.FeedbackDto;
import trainual.userservice.dto.FeedbackRequestDto;
import trainual.userservice.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/{feedbackId}")
    public ResponseEntity<FeedbackDto> getFeedback(@PathVariable("feedbackId") String feedbackId) {
        var feedback = feedbackService.getFeedback(feedbackId);
        return ResponseEntity.ok(feedback);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FeedbackDto>> getUserFeedbacks(@PathVariable("userId") String userId) {
        var feedbacks = feedbackService.getUserFeedbacks(userId);
        return ResponseEntity.ok(feedbacks);
    }

    @PutMapping("/")
    public ResponseEntity<FeedbackDto> putFeedback(@RequestBody FeedbackRequestDto requestDto) {
        var feedback = feedbackService.saveFeedback(requestDto);
        return ResponseEntity.ok(feedback);
    }
}
