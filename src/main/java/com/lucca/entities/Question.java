package com.lucca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String answer;
    private String question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "interview_id")
    private Interview interview;
}
