package com.project.backend.strategies;

import com.project.backend.domain.Transfer;

public class TransferFeeBStrategy implements TransferFeeStrategy {
    @Override
    public Float calculateFee(Transfer transfer) {
        return 12F;
    }
}
