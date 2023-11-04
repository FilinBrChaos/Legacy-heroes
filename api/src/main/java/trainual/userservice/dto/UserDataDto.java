package trainual.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDataDto {

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("reward_points_amount")
    private Integer rewardPointsAmount;

    @JsonProperty("amount_to_send")
    private Integer rewardPointsToSend;

    @JsonProperty("feedbacks")
    private List<FeedbackDto> feedbacks;
}
