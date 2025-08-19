package com.example.ForumHubChallengeBackEnd.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record TopicDataReceiverDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long authorId,
        @NotNull
        Long courseId
) {
}
