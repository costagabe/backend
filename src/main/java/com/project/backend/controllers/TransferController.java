package com.project.backend.controllers;

import com.project.backend.domain.Transfer;
import com.project.backend.dtos.CreateTransferDTO;
import com.project.backend.dtos.ReadTransferDTO;
import com.project.backend.services.TransferService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/transfer")
@AllArgsConstructor
public class TransferController {
    private final TransferService transferService;
    private final ModelMapper mapper;

    @GetMapping
    Page<ReadTransferDTO> findAll(Pageable pagination) {
        return transferService.findAll(pagination);
    }

    @PostMapping
    ReadTransferDTO create(@RequestBody CreateTransferDTO dto) {


        Transfer transfer = mapper.map(dto, Transfer.class);

        transfer.setCreatedAt(LocalDate.now());
        LocalDate scheduleDate = LocalDate.parse(dto.getScheduleDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        transfer.setScheduleDate(scheduleDate);
        transferService.create(transfer);
        return mapper.map(transfer, ReadTransferDTO.class);
    }

}
