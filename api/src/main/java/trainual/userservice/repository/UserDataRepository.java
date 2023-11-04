package trainual.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainual.userservice.model.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {

   UserData findFirstByUserId (Integer userId);
}
