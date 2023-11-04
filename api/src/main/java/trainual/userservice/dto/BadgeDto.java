package trainual.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BadgeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("badgeUrl")
    private String badgeUrl;
}
