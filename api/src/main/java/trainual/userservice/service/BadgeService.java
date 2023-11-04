package trainual.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainual.userservice.dto.BadgeDto;
import trainual.userservice.mapper.BadgeMapper;
import trainual.userservice.repository.BadgeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private BadgeMapper badgeMapper;

    public List<BadgeDto> getAllBadges(){
        return badgeRepository.findAll()
                .stream()
                .map(badgeMapper::toBadgeDto)
                .collect(Collectors.toList());
    }

    public String getBadgeUrl(Long badgeId) {
        return badgeRepository.getReferenceById(badgeId).getBadgeUrl();
    }
}
