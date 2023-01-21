package com.project.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChartsDTO {
    private Float dayValue;
    private Float weekValue;
    private Float monthValue;
    private Float dayFee;
    private Float weekFee;
    private Float monthFee;
}
