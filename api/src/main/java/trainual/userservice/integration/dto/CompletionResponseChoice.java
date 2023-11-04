package trainual.userservice.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CompletionResponseChoice {

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("finish_reason")
    private String finishReason;

    @JsonProperty("message")
    ChatGptMessage message;
}
