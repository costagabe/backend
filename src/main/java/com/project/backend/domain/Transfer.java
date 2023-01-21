package com.project.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "transfer_table")
@Data
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate createdAt;

    private LocalDate scheduleDate;

    private Float transferValue;

    private Float fee;

    private String sourceAccount;

    private String destinationAccount;
}
