package com.project.backend.utils.transfer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransferQueryField {
    TRANSFER_VALUE("transferValue"),
    FEE("fee");

    private final String value;
}
