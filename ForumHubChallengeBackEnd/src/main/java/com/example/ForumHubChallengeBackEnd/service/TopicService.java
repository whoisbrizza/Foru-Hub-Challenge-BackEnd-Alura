package com.example.ForumHubChallengeBackEnd.service;

import com.example.ForumHubChallengeBackEnd.model.TopicModel;
import com.example.ForumHubChallengeBackEnd.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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

    public TopicModel create(String title, String message, Long authorId, Long courseId) {
        // Verifica se já existe um tópico com o mesmo título e mensagem
        var existingTopic = topicRepository.findByTitle(title);
        if (existingTopic != null) {
           throw new RuntimeException();
        }

        // Cria uma nova instância de TopicModel
        var newTopic = new TopicModel();
        newTopic.setTitle(title);
        newTopic.setMessage(message);
        newTopic.setCreationDate(LocalDateTime.now());
        newTopic.setStatus("NAO_RESPONDIDO"); // Definindo o status inicial
        //newTopic.setAuthorId(authorId);
        //newTopic.setCourseId(courseId);

        // Salva o novo tópico no banco de dados usando o repositório
        return topicRepository.save(newTopic);
    }

    public TopicModel updateTopic(Long id, String newTitle, String newMessage) {
        var existingTopic = topicRepository.findById(id).orElse(null);

        if (existingTopic == null) {
            return null;
        }
        if (newTitle != null && !newTitle.isBlank()) {
            existingTopic.setTitle(newTitle);
        }
        if (newMessage != null && !newMessage.isBlank()) {
            existingTopic.setMessage(newMessage);
        }

        return topicRepository.save(existingTopic);
    }


}
