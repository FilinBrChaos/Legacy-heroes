package trainual.userservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trainual.userservice.dto.UserDataDto;
import trainual.userservice.service.FeedbackService;
import trainual.userservice.service.UserService;

@RestController
@RequestMapping(value = "/v1/user")
public class UserDataController {

    @Autowired
    private UserService userService;
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDataDto> getUserData(@PathVariable("userId") String userId) {
        var userData = userService.getUserData(userId);
        userData.setFeedbacks(feedbackService.getUserFeedbacks(userId));
        return ResponseEntity.ok(userData);
    }

}
