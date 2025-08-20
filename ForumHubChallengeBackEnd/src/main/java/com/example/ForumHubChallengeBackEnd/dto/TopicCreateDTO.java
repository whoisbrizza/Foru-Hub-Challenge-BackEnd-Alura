package com.example.ForumHubChallengeBackEnd.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicCreateDTO(
        @JsonAlias("title")
        @NotBlank
        String title,
        @JsonAlias("message")
        @NotBlank
        String message,
        @JsonAlias("status")
        @NotBlank
        String status,
        @JsonAlias("authorId")
        @NotNull
        Long authorId,
        @JsonAlias("courseId")
        @NotNull
        Long courseId

) {
}