package com.project.backend.utils.transfer;

import com.project.backend.domain.Transfer;
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
            throw new RuntimeException("You cant transfer less than 0 reais");
        if (transfer.getCreatedAt().isAfter(transfer.getScheduleDate()))
            throw new RuntimeException("You cant schedule a transfer before the transfer date");
    }
}

