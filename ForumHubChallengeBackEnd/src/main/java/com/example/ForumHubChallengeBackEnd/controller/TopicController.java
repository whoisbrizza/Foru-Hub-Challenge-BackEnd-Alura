package com.example.ForumHubChallengeBackEnd.controller;

import com.example.ForumHubChallengeBackEnd.dto.TopicDataReceiverDTO;
import com.example.ForumHubChallengeBackEnd.model.TopicModel;
import com.example.ForumHubChallengeBackEnd.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private TopicService topicService;

    public  TopicController(TopicService topicService) {
        this.topicService = topicService;

    }
    @GetMapping
    public ResponseEntity<List<TopicModel>> getAllTopics() {
        var topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TopicModel>> getTopicById(@PathVariable Long id) {
        var topic = topicService.getTopicById(id);
        if (topic == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(topic);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicModel> createTopic(@RequestBody @Valid TopicDataReceiverDTO data) {
        var topicCreated = topicService.create(data.title(), data.message(), data.authorId(), data.courseId());
        var uri = UriComponentsBuilder.fromPath("/topicos/{id}").buildAndExpand(topicCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(topicCreated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TopicModel> updateTopic(@PathVariable Long id, @RequestBody @Valid TopicDataReceiverDTO data) {
        var updatedTopic = topicService.updateTopic(id, data.title(), data.message());
        if (updatedTopic == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTopic);
    }
}