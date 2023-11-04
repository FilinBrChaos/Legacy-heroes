package trainual.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainual.userservice.dto.UserDataDto;
import trainual.userservice.integration.ChatGptService;
import trainual.userservice.mapper.UserDataMapper;
import trainual.userservice.model.UserData;
import trainual.userservice.repository.UserDataRepository;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserDataRepository userDataRepository;
    @Autowired
    private UserDataMapper userDataMapper;
    @Autowired
    private ChatGptService chatGptService;

    public UserDataDto getUserData(String userId) {
        saveNewUserIfNotExist(Integer.valueOf(userId));
        var userData = userDataRepository.findById(Integer.valueOf(userId));
        return userDataMapper.toUserData(userData.get());
    }

    public void updateUserNickname(List<String> feedbacks, Integer userId) throws IOException {
        var generatedNickname = chatGptService.generateNickname(feedbacks);
        var userData = userDataRepository.findById(Integer.valueOf(userId)).get();
        userData.setNickname(generatedNickname);
        userDataRepository.saveAndFlush(userData);
    }

    public void addRewardPoints(Integer userId, Integer points) {
        var userData = userDataRepository.findById(Integer.valueOf(userId)).get();
        var currentPoints = userData.getRewardPointsAmount();
        userData.setRewardPointsAmount(currentPoints + points);
        userDataRepository.saveAndFlush(userData);
    }

    public void saveNewUserIfNotExist(Integer userId) {
        if (!userDataRepository.existsById(userId)) {
            var userData = new UserData();
            userData.setUserId(userId);
            userData.setRewardPointsAmount(0);
            userData.setRewardPointsToSend(30);
            userDataRepository.saveAndFlush(userData);
        }
    }
}
