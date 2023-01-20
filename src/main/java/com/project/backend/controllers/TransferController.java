package com.project.backend.controllers;

import com.project.backend.dtos.ReadTransferDTO;
import com.project.backend.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transfer")
@AllArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @GetMapping
    Page<ReadTransferDTO> findAll(Pageable pagination) {
        return transferService.findAll(pagination);
    }

}
