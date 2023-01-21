package com.project.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransferDTO {
    private String scheduleDate;
    private Double transferValue;
    private String sourceAccount;
    private String destinationAccount;
}
