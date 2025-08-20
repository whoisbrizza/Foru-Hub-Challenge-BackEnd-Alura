package com.example.ForumHubChallengeBackEnd.service;

import com.example.ForumHubChallengeBackEnd.dto.TopicCreateDTO;
import com.example.ForumHubChallengeBackEnd.exception.DuplicateTopicException;
import com.example.ForumHubChallengeBackEnd.model.TopicModel;
import com.example.ForumHubChallengeBackEnd.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<TopicModel> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<TopicModel> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    public TopicModel create(@Valid TopicCreateDTO data) {
        var existingTopic = topicRepository.findByTitle(data.title());
        if (existingTopic != null) {
            throw new DuplicateTopicException("A topic with this title and message already exists.");
        }

        var newTopic = new TopicModel();
        newTopic.setTitle(data.title());
        newTopic.setMessage(data.message());
        newTopic.setCreationDate(LocalDateTime.now());
        newTopic.setStatus(data.status());
        newTopic.setAuthorId(data.authorId());
        newTopic.setCourseId(data.courseId());

        return topicRepository.save(newTopic);
    }

    public TopicModel updateTopic(Long id,  TopicCreateDTO data) {
        var existingTopic = topicRepository.findById(id).orElse(null);

        if (existingTopic == null) {
            return null;
        }
        if (data.title() != null && !data.title().isBlank()) {
            existingTopic.setTitle(data.title());
        }
        if (data.message() != null && !data.message().isBlank()) {
            existingTopic.setMessage(data.message() );
        }

        if (data.status() != null && !data.status().isBlank()) {
            existingTopic.setStatus(data.status() );
        }

        return topicRepository.save(existingTopic);
    }

    public boolean deleteTopic(Long id) {
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
