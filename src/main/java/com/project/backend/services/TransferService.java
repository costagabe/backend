package com.project.backend.services;

import com.project.backend.domain.Transfer;
import com.project.backend.dtos.ReadTransferDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransferService {
    Transfer create(Transfer transfer);

    void delete(Long id);

    Page<ReadTransferDTO> findAll(Pageable pagination);
}
