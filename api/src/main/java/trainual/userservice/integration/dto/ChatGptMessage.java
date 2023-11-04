package trainual.userservice.integration.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatGptMessage {

    @JsonProperty("role")
    String role;

    @JsonProperty("content")
    String content;
}
