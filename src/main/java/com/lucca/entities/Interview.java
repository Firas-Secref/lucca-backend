package com.lucca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interviewId;

    private String interviewDescription;
    private String period;
    @Column(nullable = true)
    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToMany(mappedBy = "interview", cascade = CascadeType.REMOVE)
    private List<Question> questions;
}
