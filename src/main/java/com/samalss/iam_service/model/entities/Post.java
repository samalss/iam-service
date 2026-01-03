package com.samalss.iam_service.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Table(name="posts")
@Getter
@Service
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = false, columnDefinition = "Integer deefault 0")
    private Integer likes = 0;
}
