package trainual.userservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trainual.userservice.dto.BadgeDto;
import trainual.userservice.service.BadgeService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/badge")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @GetMapping("/all")
    public ResponseEntity<List<BadgeDto>> getBadgesList() {
        return ResponseEntity.ok(badgeService.getAllBadges());
    }
}
