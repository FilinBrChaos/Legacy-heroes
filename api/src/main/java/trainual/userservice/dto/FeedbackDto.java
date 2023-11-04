package trainual.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FeedbackDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("fromUserId")
    private Integer fromUserId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("badgeUrl")
    private String badgeUrl;

    @JsonProperty("rewardPoints")
    private Integer rewardPoints;

    private Date createDate;
}
