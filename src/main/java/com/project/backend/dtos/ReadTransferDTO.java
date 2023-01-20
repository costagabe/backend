package com.project.backend.dtos;

import lombok.Data;

@Data
public class ReadTransferDTO {
    private Long id;
    private String scheduleDate;
    private Double value;
    private Double fee;
    private String sourceAccount;
    private String destinationAccount;
}
