package trainual.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainual.userservice.dto.UserDataDto;
import trainual.userservice.mapper.UserDataMapper;
import trainual.userservice.model.UserData;
import trainual.userservice.repository.UserDataRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserDataRepository userDataRepository;
    @Autowired
    private UserDataMapper userDataMapper;

    public UserDataDto getUserData(String userId) {
        saveNewUserIfNotExist(Integer.valueOf(userId));
        var userData = userDataRepository.findById(Integer.valueOf(userId));
        return userDataMapper.toUserData(userData.get());
    }

    public void generateUserNickname(Integer userId) {
        //TODO
    }

    public void addRewardPoints(Integer userId, Integer points) {
        //TODO
    }


    public void saveNewUserIfNotExist(Integer userId) {
        if (!userDataRepository.existsById(userId)) {
            var userData = new UserData();
            userData.setUserId(userId);
            userData.setNickname("sdfsdfsdfsfs"); //TODO
            userData.setRewardPointsAmount(0);
            userData.setRewardPointsToSend(0);
            userDataRepository.save(userData);
        }
    }
}
