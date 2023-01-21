package com.project.backend.services.impl;

import com.project.backend.domain.Transfer;
import com.project.backend.dtos.ReadTransferDTO;
import com.project.backend.repositories.TransferRepository;
import com.project.backend.services.TransferService;
import com.project.backend.utils.transfer.TransferFeeFactory;
import lombok.AllArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final ModelMapper mapper;

    @Override
    public void create(Transfer transfer) {
        Float fee = TransferFeeFactory.createTransferFee(transfer).calculateFee(transfer);
        transfer.setFee(fee);
        transferRepository.save(transfer);
    }

    @Override
    public void delete(Long id) {
        throw new NotYetImplementedException();
    }

    @Override
    public Page<ReadTransferDTO> findAll(Pageable pagination) {
        return transferRepository.findAll(pagination).map(transfer -> mapper.map(transfer, ReadTransferDTO.class));
    }
}
