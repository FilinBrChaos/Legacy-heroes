package trainual.userservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import trainual.userservice.integration.dto.CompletionResponse;
import trainual.userservice.integration.dto.ChatGptMessage;
import trainual.userservice.integration.dto.PromptRequest;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    @Autowired
    private Environment env;

    public String generateNickname(List<String> feedbacks) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, new ObjectMapper().writeValueAsString(getRequest(feedbacks)));

        Request request = new Request.Builder()
                .url(Objects.requireNonNull(env.getProperty("chat.gpt.url")) + "/completions")
                .post(body)
                .addHeader("Authorization", "Bearer " + env.getProperty("chat.gpt.token"))
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();
        System.out.println(responseBody);
        var completion =  new ObjectMapper().readValue(responseBody.string(), CompletionResponse.class);
        return completion.getChoices().get(0).getMessage().getContent();
    }

    private PromptRequest getRequest(List<String> feedbacks) {
        var model = env.getProperty("chat.gpt.model");
        var feedbacksAsText = feedbacks.stream()
                .collect(Collectors.joining(System.lineSeparator()));
        var prompt = "Generate me a funny nickname for employee based on next feedbacks:" + System.lineSeparator() + feedbacksAsText;
        var messageRequest = new ChatGptMessage();
        messageRequest.setContent(prompt);
        messageRequest.setRole("user");
        var request = new PromptRequest();
        request.setModel(model);
        request.setMessages(List.of(messageRequest));
        return request;
    }
}
