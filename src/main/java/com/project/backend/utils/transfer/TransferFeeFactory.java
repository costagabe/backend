package com.project.backend.utils.transfer;

import com.project.backend.domain.Transfer;
import com.project.backend.exceptions.InvalidTransferException;
import com.project.backend.strategies.*;

import java.time.Duration;

public class TransferFeeFactory {
    public static TransferFeeStrategy createTransferFee(Transfer transfer) {
        validateTransfer(transfer);

        if (transfer.getTransferValue() > 1000)
            return new TransferFeeDStrategy();

        long diff = Duration.between(transfer.getCreatedAt().atStartOfDay(), transfer.getScheduleDate().atStartOfDay()).toDays();
        if (diff == 0)
            return new TransferFeeAStrategy();
        if (diff <= 10)
            return new TransferFeeBStrategy();

        return new TransferFeeCStrategy();

    }

    private static void validateTransfer(Transfer transfer) {
        if (transfer.getTransferValue() <= 0)
            throw new InvalidTransferException("Você não pode transferir menos de 0 reais.");
        if (transfer.getCreatedAt().isAfter(transfer.getScheduleDate()))
            throw new InvalidTransferException("Você não pode agendar uma transferência para antes da data atual.");
    }
}

