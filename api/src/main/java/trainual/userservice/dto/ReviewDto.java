package trainual.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("description")
    private String description;
}
