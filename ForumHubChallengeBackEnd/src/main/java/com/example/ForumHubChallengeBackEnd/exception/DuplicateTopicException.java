package com.example.ForumHubChallengeBackEnd.exception;

public class DuplicateTopicException extends RuntimeException {
    public DuplicateTopicException(String message) {
        super(message);
    }
}
