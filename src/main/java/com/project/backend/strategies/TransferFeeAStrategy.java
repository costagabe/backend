package com.project.backend.strategies;

import com.project.backend.domain.Transfer;

public class TransferFeeAStrategy implements TransferFeeStrategy {
    @Override
    public Float calculateFee(Transfer transfer) {
        return 3 + (transfer.getTransferValue() * 0.03F);
    }
}
