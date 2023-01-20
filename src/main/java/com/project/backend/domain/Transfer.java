package com.project.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer_table")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDate scheduleDate;

    private Float transferValue;

    private Float fee;

    private String sourceAccount;

    private String destinationAccount;
}
