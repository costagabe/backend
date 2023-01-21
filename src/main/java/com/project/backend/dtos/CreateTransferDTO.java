package com.project.backend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTransferDTO {
    private String scheduleDate;
    private Double transferValue;
    private String sourceAccount;
    private String destinationAccount;
}
