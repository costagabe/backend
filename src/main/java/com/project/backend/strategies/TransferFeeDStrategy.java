package com.project.backend.strategies;

import com.project.backend.domain.Transfer;

public class TransferFeeDStrategy implements TransferFeeStrategy {
    @Override
    public Float calculateFee(Transfer transfer) {
        if (transfer.getTransferValue() > 2000)
            return new TransferFeeCStrategy().calculateFee(transfer);
        if (transfer.getTransferValue() > 1000)
            return new TransferFeeBStrategy().calculateFee(transfer);
        if (transfer.getTransferValue() <= 1000)
            return new TransferFeeAStrategy().calculateFee(transfer);
        throw new RuntimeException("You cant transfer more than 2000 reais before 10 days");
    }
}
