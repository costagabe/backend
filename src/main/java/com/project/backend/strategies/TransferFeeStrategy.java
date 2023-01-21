package com.project.backend.strategies;

import com.project.backend.domain.Transfer;

public interface TransferFeeStrategy {
    Float calculateFee(Transfer transfer);
}



