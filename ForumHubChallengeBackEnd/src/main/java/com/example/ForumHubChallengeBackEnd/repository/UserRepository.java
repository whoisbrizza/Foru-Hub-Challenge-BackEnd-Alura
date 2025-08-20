package com.example.ForumHubChallengeBackEnd.repository;

import com.example.ForumHubChallengeBackEnd.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);
}