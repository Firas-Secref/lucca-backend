package com.lucca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int holidayId;

    private int employeeId;
    private int holidayCount;

}
