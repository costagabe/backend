package com.project.backend.strategies;

import com.project.backend.domain.Transfer;
import com.project.backend.exceptions.InvalidTransferException;

public class TransferFeeDStrategy implements TransferFeeStrategy {
    @Override
    public Float calculateFee(Transfer transfer) {
        if (transfer.getTransferValue() > 2000)
            return new TransferFeeCStrategy().calculateFee(transfer);
        if (transfer.getTransferValue() > 1000)
            return new TransferFeeBStrategy().calculateFee(transfer);
        if (transfer.getTransferValue() <= 1000)
            return new TransferFeeAStrategy().calculateFee(transfer);
        throw new InvalidTransferException("Você não pode transferir mais de 2000 reais em antes de 10 dias");
    }
}
