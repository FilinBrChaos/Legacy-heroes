package trainual.userservice.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PromptRequest {

    @JsonProperty("model")
    String model;

    @JsonProperty("messages")
    List<ChatGptMessage> messages;
}
