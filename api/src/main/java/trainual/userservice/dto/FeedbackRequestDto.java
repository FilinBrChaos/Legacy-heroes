package trainual.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedbackRequestDto {

    @NotBlank(message = "user id should not be blank")
    @JsonProperty("userId")
    private Integer userId;

    @NotBlank(message = "from user id should not be blank")
    @JsonProperty("fromUserId")
    private Integer fromUserId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("badgeUrl")
    private String badgeUrl;

    @JsonProperty("score")
    private Integer score;
}
