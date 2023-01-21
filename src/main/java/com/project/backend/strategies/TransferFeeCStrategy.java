package com.project.backend.strategies;

import com.project.backend.domain.Transfer;
import com.project.backend.exceptions.InvalidTransferException;

import java.time.Duration;

public class TransferFeeCStrategy implements TransferFeeStrategy {
    @Override
    public Float calculateFee(Transfer transfer) {
        long diff = Duration.between(transfer.getCreatedAt().atStartOfDay(), transfer.getScheduleDate().atStartOfDay()).toDays();
        if (diff > 10 && diff <= 20)
            return transfer.getTransferValue() * 0.082F;
        else if (diff > 20 && diff <= 30)
            return transfer.getTransferValue() * 0.069F;
        else if (diff > 30 && diff <= 40)
            return transfer.getTransferValue() * 0.047F;
        else if (diff > 40)
            return transfer.getTransferValue() * 0.017F;
        throw new InvalidTransferException("A data que você escolheu não é válida para o valor da operação. Por favor, cheque a tabela");
    }
}