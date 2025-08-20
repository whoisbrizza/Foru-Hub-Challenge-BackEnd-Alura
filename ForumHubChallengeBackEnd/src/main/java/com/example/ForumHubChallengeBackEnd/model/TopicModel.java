package com.example.ForumHubChallengeBackEnd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@NoArgsConstructor
@Getter
@Setter
public class TopicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "status")
    private String status;

    @Column(name = "author")
    private Long authorId;

    @Column(name = "course_id")
    private Long courseId;
}
