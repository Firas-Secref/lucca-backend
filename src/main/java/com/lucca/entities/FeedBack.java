package com.lucca.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedBack implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feedBackId;
    private String feedBackText;
    private int employeeId;
    private String feedBackType;

    @ManyToOne
    @JoinColumn(name = "candidate_id", updatable = false, insertable = false)
    @JsonBackReference
    private User user;
}
