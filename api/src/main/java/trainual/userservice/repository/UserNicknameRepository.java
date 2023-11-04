package trainual.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainual.userservice.model.Feedback;
import trainual.userservice.model.UserGeneratedNickname;

import java.util.List;

public interface UserNicknameRepository extends JpaRepository<UserGeneratedNickname, Long> {

   UserGeneratedNickname findFirstByUserId (Integer userId);
}
