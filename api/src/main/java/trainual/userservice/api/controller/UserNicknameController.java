package trainual.userservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trainual.userservice.dto.FeedbackDto;
import trainual.userservice.dto.FeedbackRequestDto;
import trainual.userservice.service.FeedbackService;
import trainual.userservice.service.UserNicknameService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/userNickname")
public class UserNicknameController {

    @Autowired
    private UserNicknameService userNicknameService;

    @GetMapping("/{userId}")
    public ResponseEntity<String> getUserGeneratedNickname(@PathVariable("userId") String userId) {
        var userNickname = userNicknameService.getUserNickname(userId);
        return ResponseEntity.ok(userNickname);
    }

}
