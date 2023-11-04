package trainual.userservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "user_nickname")
@NoArgsConstructor
public class UserData {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "nickname")
    private String nickname;

    @Column(name="reward_points_amount")
    private Integer rewardPointsAmount;

    @Column(name="amount_to_send")
    private Integer rewardPointsToSend;
}
