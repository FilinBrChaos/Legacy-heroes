package trainual.userservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trainual.userservice.dto.BadgeDto;
import trainual.userservice.service.BadgeService;

import java.io.IOException;
import java.io.InputStream;
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

    @GetMapping("/{badgePath}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImageDynamicType(@PathVariable("badgePath") String badgePath) throws IOException {
        MediaType contentType = MediaType.IMAGE_PNG;
        InputStream in = new ClassPathResource("badges/" + badgePath).getInputStream();
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(in));
    }
}
