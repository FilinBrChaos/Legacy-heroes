package trainual.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewDto {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("userId")
    public Integer userId;

    @JsonProperty("description")
    public String description;
}
