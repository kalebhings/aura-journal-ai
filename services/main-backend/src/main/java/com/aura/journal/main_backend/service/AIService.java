package com.aura.journal.main_backend.service;

import com.aura.journal.main_backend.dto.SentimentResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service // Tells Spring this is a service class
public class AIService {

    private final WebClient webClient;

    // We configure the WebClient to always point to our Python service's URL
    public AIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8000").build();
    }

    public SentimentResponse getSentiment(String text) {
        // This is the "payload" we will send to the Python service
        // It's a Map that will be converted to: {"text": "your text here"}
        Map<String, String> payload = Map.of("text", text);

        // This is the actual web request
        return this.webClient.post()
                .uri("/analyze/sentiment") // The endpoint on the Python service
                .bodyValue(payload)
                .retrieve() // Execute the request
                .bodyToMono(SentimentResponse.class) // Convert the JSON response to our DTO
                .block(); // Wait for the response to come back
    }
}