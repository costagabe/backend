package com.project.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadTransferDTO {
    private  Long id;
    private  String scheduleDate;

    private String createdAt;
    private  Double transferValue;
    private  Double fee;
    private  String sourceAccount;
    private  String destinationAccount;
}
