package com.aura.journal.main_backend.dto;

import lombok.Data;

// Using @Data from Lombok to auto-create getters/setters
@Data
public class SentimentResponse {
    // These field names MUST match the JSON from the Python service
    private String sentiment;
    private double score;
}