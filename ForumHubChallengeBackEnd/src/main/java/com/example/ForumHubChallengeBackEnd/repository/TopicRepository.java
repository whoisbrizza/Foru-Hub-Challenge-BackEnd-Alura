package com.example.ForumHubChallengeBackEnd.repository;



import com.example.ForumHubChallengeBackEnd.model.TopicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicModel, Long> {

    TopicModel findByTitle(String title);
}
